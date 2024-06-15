package com.example.pearl.presentation.routines

import com.example.pearl.domain.model.Product
import com.example.pearl.domain.model.Routine

sealed class RoutineEvents {
    data class SwitchRoutineTime(val routineTimeData: RoutineTimeData, val pos : RoutineTimePositions) : RoutineEvents()
    data class SelectRoutineTime(val time: RoutineTime) : RoutineEvents()
    data class AddProductToRoutine(val product : Product , val routineTime : String) : RoutineEvents()
    object ShowBottomSheet : RoutineEvents()
    object HideBottomSheet : RoutineEvents()
    object ShowSuccessDialog : RoutineEvents()
    object HideSuccessDialog : RoutineEvents()
    data class ShowFailureDialog(val errorMessage : String) : RoutineEvents()
    object HideFailureDialog : RoutineEvents()

    object ShowConfirmDeleteDialog : RoutineEvents()
    object HideConfirmDeleteDialog : RoutineEvents()
    object ObserveRoutineList : RoutineEvents()

    data class SelectRoutineID(val routineId: String) : RoutineEvents()
    data class RemoveRoutine(val routineId: String) : RoutineEvents()
}

enum class RoutineTimePositions{START,END}