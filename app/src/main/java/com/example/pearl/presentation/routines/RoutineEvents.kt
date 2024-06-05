package com.example.pearl.presentation.routines

sealed class RoutineEvents {
    data class SwitchRoutineTime(val routineTimeData: RoutineTimeData, val pos : RoutineTimePositions) : RoutineEvents()
    data class SelectRoutineTime(val time: RoutineTime) : RoutineEvents()
}

enum class RoutineTimePositions{START,END}