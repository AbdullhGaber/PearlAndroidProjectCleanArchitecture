package com.example.pearl.domain.model

data class Routine(
    val id: String = "-1",
    val product: Product = Product(),
    val time: RoutineTime = RoutineTime.MORNING
)
