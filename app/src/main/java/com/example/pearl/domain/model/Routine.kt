package com.example.pearl.domain.model


import com.example.pearl.presentation.products.ProductType
import com.example.pearl.presentation.routines.RoutineTime
data class Routine(
    val id : String = "-1",
    val product : Product = Product(),
    val time : RoutineTime = RoutineTime.MORNING
)