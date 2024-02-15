package com.example.pearl.presentation.settings

data class CollapsingMenuData(
    val title : String,
    val content : String
)


val collapsingMenuDataList = listOf(
    CollapsingMenuData(
        title = "How to know my skin type?",
        content = "Our app employs advanced algorithms to analyze user-provided information and images, helping identify your skin type accurately."
    ),

    CollapsingMenuData(
        title = "How to get a personalized skin care routine? ",
        content = "Our app employs advanced algorithms to analyze user-provided information and images, helping identify your skin type accurately."
    ),

    CollapsingMenuData(
        title = "How to add products to my skincare routine?",
        content = "Our app employs advanced algorithms to analyze user-provided information and images, helping identify your skin type accurately."
    ),
)