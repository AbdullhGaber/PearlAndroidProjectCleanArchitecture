package com.example.pearl.presentation.recipes

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class RecipesData(
    val id : Int = -1,
    @DrawableRes val icon : Int,
    val title : String,
    val body : String,
    val loves : Int = 0,
    val delicious : Int = 0,
    val dislikes : Int = 0,
    val unsatisfied : Int = 0,
    val ingredients: List<String> = emptyList(),
    val instructions : List<String> = emptyList()
    )

val recipesList = listOf(
    RecipesData(
        id = 1,
        icon = R.drawable.salamon ,
        title = "Grilled Salmon & Quinoa",
        body = "It provides omega-3 fatty acids, balanced nutrition, and essential vitamins, potentially regulating oil production.",
        loves = 374,
        delicious = 249,
        dislikes = 42,
        unsatisfied = 128,
        ingredients = listOf(
            "Salmon fillets",
            "Quinoa",
            "Mixed vegetables (broccoli, carrots, bell peppers)",
            "Olive oil",
            "Lemon juice",
            "Garlic",
            "Salt and pepper to taste"
        ),
        instructions = listOf(
            "Grill the salmon fillets with a drizzle of olive oil, lemon juice, minced garlic, salt, and pepper.",
            "Cook quinoa according to package instructions.",
            "Cook quinoa according to package instructions.",
            "Serve the grilled salmon over a bed of quinoa and steamed vegetables."
        )
    ),

    RecipesData(
        id = 2,
        icon = R.drawable.green_juice ,
        title = "Citrus Green Juice",
        body = "This Juice provides hydration, antioxidants, vitamins, and potential anti-inflammatory benefits.",
        loves = 238,
        delicious = 114,
        dislikes = 27,
        unsatisfied = 53
    ),

    RecipesData(
        id =3,
        icon = R.drawable.vegetable_soap ,
        title = "Lentil & Vegetable Soup",
        body = "It provides a wholesome blend of plant-based protein, fiber, vitamins, and minerals, contributing to skin health",
        loves = 84,
        delicious = 72,
        dislikes = 15,
        unsatisfied = 24
    ),

    RecipesData(
        id = 4,
        icon = R.drawable.avocado_dish ,
        title = "Avocado & Chickpea Salad",
        body = "It delivers a nourishing mix of healthy fats, fiber, antioxidants, and vitamins, supporting skin health.\n",
        loves = 127,
        delicious = 97,
        dislikes = 32,
        unsatisfied = 41
    ),

    RecipesData(
        id = 5,
        icon = R.drawable.pizza ,
        title = "Mediterranean Pizza",
        body = "It delivers a nourishing mix of healthy fats, fiber, antioxidants, and vitamins, supporting skin health.\n",
        loves = 238,
        delicious = 114,
        dislikes = 27,
        unsatisfied = 53
    ),
)