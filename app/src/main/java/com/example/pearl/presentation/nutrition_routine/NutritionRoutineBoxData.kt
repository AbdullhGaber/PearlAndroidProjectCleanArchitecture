package com.example.pearl.presentation.nutrition_routine

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class NutritionRoutineBoxData(
    @DrawableRes val image : Int ,
    val title : String,
    val body : String
)

val nutritionRoutineBoxDataList = listOf(
    NutritionRoutineBoxData(
        image = R.drawable.avocadopng,
        title = "Stick to or Avoid",
        body = "Optimize your skin health by making mindful choices. Avoid skin-stressing foods and stick to nourishing options for a radiant complexion."
    ),

    NutritionRoutineBoxData(
        image = R.drawable.nutrition_routine,
        title = "Recipes for you",
        body = "Indulge in a culinary journey with recipes customized for your skin. Discover delicious and nutritious options designed to enhance your skin's natural radiance."
    )
)