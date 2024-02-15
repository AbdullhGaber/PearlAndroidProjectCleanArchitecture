package com.example.pearl.presentation.routines

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class StickAvoidRoutineData(
    @DrawableRes val icon : Int,
    val title : String,
    val body : String,
    val stickTo : Boolean = true
)

val stickAvoidRoutineList = listOf(
    StickAvoidRoutineData(
        icon = R.drawable.apple ,
        title = "Fruits and Vegetables",
        body = "Colorful fruits and vegetables are rich in antioxidants, which can help combat free radicals."
    ),

    StickAvoidRoutineData(
        icon = R.drawable.fish ,
        title = "Omega-3 Fatty Acids",
        body = "Salmon, chia seeds, and flaxseeds, may help reduce inflammation and contribute to healthy skin."
    ),

    StickAvoidRoutineData(
        icon = R.drawable.whole_grains ,
        title = "Whole Grains",
        body = "Brown rice, quinoa, and oats have a lower glycemic index, which may help control skin oil production"
    ),

    StickAvoidRoutineData(
        icon = R.drawable.carrot,
        title = "Vitamin A-rich Foods",
        body = "Carrots, spinach, and leafy greens support the shedding of dead skin cells, preventing them from pores."
    ),

    StickAvoidRoutineData(
        icon = R.drawable.cheese,
        title = "Dairy",
        body = "Dairy products can trigger acne or worsen oily skin.",
        stickTo = false
    ),

    StickAvoidRoutineData(
        icon = R.drawable.dount,
        title = "Sugary Foods",
        body = "High sugar intake can lead to increased insulin levels, potentially influencing sebum production.",
        stickTo = false
    ),

    StickAvoidRoutineData(
        icon = R.drawable.fries,
        title = "Fried Foods",
        body = "Foods cooked in unhealthy oils and high in trans fats can contribute to inflammation.",
        stickTo = false
    ),

    StickAvoidRoutineData(
        icon = R.drawable.coffee,
        title = "Excessive Caffeine",
        body = "Excessive caffeine can lead to dehydration, potentially affecting skin health.",
        stickTo = false
    ),


)