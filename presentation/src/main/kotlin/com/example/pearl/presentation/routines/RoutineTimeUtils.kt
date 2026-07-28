package com.example.pearl.presentation.routines

import com.example.pearl.domain.model.RoutineTime

fun getRoutineTimeByString(routineTime : String) : RoutineTime{

    return when(routineTime){
        routineTimeDataMap[RoutineTime.MORNING]?.title -> RoutineTime.MORNING
        routineTimeDataMap[RoutineTime.NIGHT]?.title -> RoutineTime.NIGHT
        routineTimeDataMap[RoutineTime.WEEKLY]?.title -> RoutineTime.WEEKLY
        else -> RoutineTime.MORNING
    }

}
