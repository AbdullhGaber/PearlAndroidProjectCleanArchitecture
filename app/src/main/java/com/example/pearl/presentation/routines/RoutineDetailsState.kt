package com.example.pearl.presentation.routines

import com.example.pearl.domain.model.Routine


data class RoutineDetailsState(
    val startPosRoutineTime : RoutineTimeData = routineTimeDataMap[RoutineTime.NIGHT]!!,
    val centerPosRoutineTime : RoutineTimeData = routineTimeDataMap[RoutineTime.MORNING]!!,
    val endPosRoutineTime : RoutineTimeData = routineTimeDataMap[RoutineTime.WEEKLY]!!,
    val isSheetShown : Boolean = false,
    val isSuccessDialogShown : Boolean = false,
    val isFailureDialogShown : Boolean = false,
    val isDeleteConfirmDialogShown : Boolean = false,
    val routineIdToDelete : String  = "0",
    val errorMessage : String = "",
    val routines : List<Routine> = emptyList()
)
