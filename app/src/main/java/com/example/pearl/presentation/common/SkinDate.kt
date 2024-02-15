package com.example.pearl.presentation.common


data class SkinDate(
    val weekDay : String,
    val monthDay : String
)

val skinDates = listOf(
    SkinDate(
        weekDay = "Sat",
        monthDay = "17"
    )

    ,SkinDate(
        weekDay = "Sun",
        monthDay = "18"
    ),

    SkinDate(
        weekDay = "Mon",
        monthDay = "19"
    ),

    SkinDate(
        weekDay = "Tue",
        monthDay = "20"
    ),

    SkinDate(
        weekDay = "Wed",
        monthDay = "21"
    ),

    SkinDate(
        weekDay = "Thu",
        monthDay = "22"
    ),

    SkinDate(
        weekDay = "Fri",
        monthDay = "23"
    ),
)