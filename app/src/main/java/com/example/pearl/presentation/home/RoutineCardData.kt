package com.example.pearl.presentation.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.pearl.R

data class RoutineCardData(
    val backgroundColor : Color,
    @DrawableRes val icon : Int,
    val routineTime : String,
    val isNight : Boolean = false
)

val routineCards = listOf(
    RoutineCardData(
        backgroundColor = Color(0xFFECF3FF),
        icon = R.drawable.sun_routine,
        routineTime = "Your Morning Routine"
    ),

    RoutineCardData(
        backgroundColor = Color(0x800024A1),
        icon = R.drawable.helal_routine,
        routineTime = "Your Night Routine",
        isNight = true
    ),

     RoutineCardData(
        backgroundColor = Color(0xFFE4DBFF),
        icon = R.drawable.calender_routine,
        routineTime = "Your Weekly Routine",
    ),

)