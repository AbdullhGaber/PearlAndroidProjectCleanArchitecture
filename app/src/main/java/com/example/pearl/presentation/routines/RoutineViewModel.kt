package com.example.pearl.presentation.routines

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pearl.R

class RoutineViewModel : ViewModel() {
    val mRoutineDetailsState = mutableStateOf(RoutineDetailsState())

    fun onEvent(event: RoutineEvents){
        when(event){
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
}