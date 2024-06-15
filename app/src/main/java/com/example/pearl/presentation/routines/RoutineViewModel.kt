package com.example.pearl.presentation.routines

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pearl.domain.model.Product
import com.example.pearl.domain.model.Routine
import com.example.pearl.domain.usecases.routine.RoutineUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(
    val routineUseCases: RoutineUseCases
) : ViewModel() {

//    private val _mRoutineStateFlow  = MutableStateFlow(emptyList<Routine>())
//    val routineStateFlow = _mRoutineStateFlow.asStateFlow()

    val mRoutineDetailsState = mutableStateOf(RoutineDetailsState())
    init {
        onEvent(RoutineEvents.ObserveRoutineList)
    }

    private suspend fun getUserRoutines(
        onSuccess : (List<Routine>) -> Unit,
        onFailure : (Throwable) -> Unit,
    ) {
          routineUseCases.getRoutinesUseCase(onSuccess , onFailure)
    }

    fun onEvent(event: RoutineEvents){
        when(event){
            is RoutineEvents.SelectRoutineID -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(routineIdToDelete = event.routineId)
            }

            is RoutineEvents.ShowConfirmDeleteDialog -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isDeleteConfirmDialogShown = true)
            }

            is RoutineEvents.HideConfirmDeleteDialog -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isDeleteConfirmDialogShown = false)
            }

            is RoutineEvents.RemoveRoutine -> {
                viewModelScope.launch {
                    removeRoutine(
                        event.routineId,
                        onSuccess = {
                            onEvent(RoutineEvents.ObserveRoutineList)
                            onEvent(RoutineEvents.HideConfirmDeleteDialog)
                        },
                        onFailure = {
                            onEvent(RoutineEvents.ShowFailureDialog(it.message!!))
                        }
                    )
                }
            }

            is RoutineEvents.ObserveRoutineList -> {
                viewModelScope.launch {
                    getUserRoutines(
                        onSuccess = { routineList ->
                            mRoutineDetailsState.value = mRoutineDetailsState.value.copy(routines = routineList)
                        },
                        onFailure = {
                            RoutineEvents.ShowFailureDialog(it.message!!)
                        })
                }
            }

            is RoutineEvents.ShowFailureDialog -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isFailureDialogShown = true)
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(errorMessage = event.errorMessage)
            }

            is RoutineEvents.HideFailureDialog -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isFailureDialogShown = false)
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(errorMessage = "")
            }

            is RoutineEvents.ShowSuccessDialog -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isSuccessDialogShown = true)
            }

            is RoutineEvents.HideSuccessDialog -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isSuccessDialogShown = false)
            }

            is RoutineEvents.ShowBottomSheet -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isSheetShown = true)
            }

            is RoutineEvents.HideBottomSheet -> {
                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(isSheetShown = false)
            }

            is RoutineEvents.AddProductToRoutine -> {
                addProductToRoutine(event.product , event.routineTime)
                onEvent(RoutineEvents.ObserveRoutineList)
            }

            is RoutineEvents.SwitchRoutineTime -> {
                val currentRoutineTime = mRoutineDetailsState.value.centerPosRoutineTime
                val newRoutineTime = event.routineTimeData

                mRoutineDetailsState.value = mRoutineDetailsState.value.copy(centerPosRoutineTime = newRoutineTime)
                when(event.pos){
                    RoutineTimePositions.START -> {
                        mRoutineDetailsState.value = mRoutineDetailsState.value.copy(startPosRoutineTime = currentRoutineTime)
                    }

                    RoutineTimePositions.END -> {
                        mRoutineDetailsState.value = mRoutineDetailsState.value.copy(endPosRoutineTime = currentRoutineTime)
                    }
                }
            }

            is RoutineEvents.SelectRoutineTime -> {
                val routineTime = event.time

                when(routineTime){
                    RoutineTime.MORNING -> {
                        mRoutineDetailsState.value = mRoutineDetailsState.value.copy(
                            startPosRoutineTime = routineTimeDataMap[RoutineTime.NIGHT]!!,
                            endPosRoutineTime = routineTimeDataMap[RoutineTime.WEEKLY]!!,
                            centerPosRoutineTime = routineTimeDataMap[RoutineTime.MORNING]!!
                        )
                    }

                    RoutineTime.NIGHT -> {
                        mRoutineDetailsState.value = mRoutineDetailsState.value.copy(
                            startPosRoutineTime = routineTimeDataMap[RoutineTime.MORNING]!!,
                            endPosRoutineTime = routineTimeDataMap[RoutineTime.WEEKLY]!!,
                            centerPosRoutineTime = routineTimeDataMap[RoutineTime.NIGHT]!!
                        )
                    }

                    RoutineTime.WEEKLY -> {
                        mRoutineDetailsState.value = mRoutineDetailsState.value.copy(
                            startPosRoutineTime = routineTimeDataMap[RoutineTime.NIGHT]!!,
                            endPosRoutineTime = routineTimeDataMap[RoutineTime.MORNING]!!,
                            centerPosRoutineTime = routineTimeDataMap[RoutineTime.WEEKLY]!!
                        )
                    }
                }
            }
        }
    }

    private fun addProductToRoutine(product: Product , routineTime : String) {

        val routine = Routine(
            id = UUID.randomUUID().toString(),
            product = product,
            time = getRoutineTimeByString(routineTime)
        )

        routineUseCases.addRoutineUseCase(
            routine,
            onSuccess = {
                onEvent(RoutineEvents.ShowSuccessDialog)
            },
            onFailure = {
                onEvent(RoutineEvents.ShowFailureDialog(it.message!!))
            }
        )
    }

    private fun removeRoutine(
        routineId: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ){
        routineUseCases.removeRoutineUseCase(routineId, onSuccess, onFailure)
    }
}