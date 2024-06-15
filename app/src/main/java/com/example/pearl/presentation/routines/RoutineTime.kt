package com.example.pearl.presentation.routines

enum class RoutineTime {
    MORNING,
    NIGHT,
    WEEKLY
}

fun getRoutineTimeByString(routineTime : String) : RoutineTime{

    return when(routineTime){
        routineTimeDataMap[RoutineTime.MORNING]?.title -> RoutineTime.MORNING
        routineTimeDataMap[RoutineTime.NIGHT]?.title -> RoutineTime.NIGHT
        routineTimeDataMap[RoutineTime.WEEKLY]?.title -> RoutineTime.WEEKLY
        else -> RoutineTime.MORNING
    }

}