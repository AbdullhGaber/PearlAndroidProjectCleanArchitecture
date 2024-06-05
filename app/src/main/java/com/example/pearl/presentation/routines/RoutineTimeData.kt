package com.example.pearl.presentation.routines

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class RoutineTimeData(
   @DrawableRes val icon : Int,
   val title : String,
   @DrawableRes val bgImage : Int
)

val routineTimeDataMap = mapOf(
    RoutineTime.NIGHT to RoutineTimeData(icon = R.drawable.routine_helal_time , "Night Routine" , bgImage = R.drawable.bg_night_routine),
    RoutineTime.MORNING to RoutineTimeData(icon = R.drawable.routine_sun_time , "Morning Routine", bgImage = R.drawable.bg_day_routine),
    RoutineTime.WEEKLY to RoutineTimeData(icon = R.drawable.routine_weekly_time , "Weekly Routine", bgImage = R.drawable.bg_weekly_routine)
)
