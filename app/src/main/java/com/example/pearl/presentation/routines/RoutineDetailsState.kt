package com.example.pearl.presentation.routines
data class RoutineDetailsState(
    val startPosRoutineTime : RoutineTimeData = routineTimeDataMap[RoutineTime.NIGHT]!!,
    val centerPosRoutineTime : RoutineTimeData = routineTimeDataMap[RoutineTime.MORNING]!!,
    val endPosRoutineTime : RoutineTimeData = routineTimeDataMap[RoutineTime.WEEKLY]!!,
)
