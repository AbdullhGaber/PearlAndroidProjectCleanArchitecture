package com.example.pearl.presentation.routines

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.pearl.R

data class RoutineBoxData(
    val backgroundColor : Color,
    @DrawableRes val icon : Int,
    val title : String,
    val time : String,
    val isNight : Boolean = false,
    val number : Int? = null,
    val routineTime : RoutineTime?
)

val routineBoxes = listOf(
    RoutineBoxData(
        backgroundColor = Color(0xFFECF3FF),
        icon = R.drawable.sun_routine,
        title = "Your Morning Routine",
        time = "9:30 AM",
        number = 5,
        routineTime = RoutineTime.MORNING
    ),

    RoutineBoxData(
        backgroundColor =  Color(0x800024A1),
        icon = R.drawable.helal_routine,
        title = "Your Night Routine",
        time = "9:30 AM",
        isNight = true,
        number = 7,
        routineTime = RoutineTime.NIGHT
    ),

    RoutineBoxData(
        backgroundColor = Color(0xFFE4DBFF),
        icon = R.drawable.calender_routine,
        title = "Your Weekly Routine",
        time = "Every Sunday",
        number = 5,
        routineTime = RoutineTime.WEEKLY
    ),

    RoutineBoxData(
        backgroundColor = Color(0xFFF0FFF3),
        icon = R.drawable.fluent_food_24_filled,
        title = "Your Nutrition Routine",
        time = "Track your daily water and nutrition intake",
        routineTime = null
    ),
)