package com.example.pearl.presentation.my_skin

import androidx.compose.ui.graphics.Color

data class IssuesBoxData(
    val issue : String,
    val description : String,
    val backgroundColor : Color,
    val edgeColor : Color
)

val issueBoxDataList = listOf(
    IssuesBoxData(
        issue = "Mild Acne",
        description = "Occasional acne breakouts, including pimples, whiteheads and blackheads, can be managed with targeted skincare.",
        backgroundColor = Color(0xFFD0C5FF),
        edgeColor = Color(0xFFA3A3FF)
    ),
    )
