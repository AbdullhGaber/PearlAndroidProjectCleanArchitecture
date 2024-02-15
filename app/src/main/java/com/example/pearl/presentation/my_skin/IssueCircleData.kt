package com.example.pearl.presentation.my_skin
import androidx.compose.ui.graphics.Color

data class IssueCircleData(
    val issue : String,
    val percent : Int,
    val backgroundColor : Color,
    val edgeColor : Color
)

val issueCircleDataList = listOf(
    IssueCircleData(
        issue = "Dark Circles",
        percent = 28,
        backgroundColor = Color(0xFFD0C5FF),
        edgeColor = Color(0xFFA3A3FF)
    ),

    IssueCircleData(
        issue = "Oiliness",
        percent = 67,
        backgroundColor = Color(0x7E7EE97B),
        edgeColor = Color(0xFF7EE97B)
    ),

    IssueCircleData(
        issue = "Redness",
        percent = 30,
        backgroundColor = Color(0xFFFAE6E6),
        edgeColor = Color(0xFFED8B8B)
    ),

    IssueCircleData(
        issue = "Pigmentation",
        percent = 55,
        backgroundColor = Color(0xFFFDFFA9),
        edgeColor = Color(0xFFDCDE8C)
    ),

)

val skinConcernsCircleDataList = listOf(
    IssueCircleData(
        issue = "Acne",
        percent = 58,
        backgroundColor = Color(0xFFD0C5FF),
        edgeColor = Color(0xFFA3A3FF)
    ),

    IssueCircleData(
        issue = "Pores",
        percent = 81,
        backgroundColor = Color(0x7E7EE97B),
        edgeColor = Color(0xFF7EE97B)
    ),

    IssueCircleData(
        issue = "Wrinkles",
        percent = 25,
        backgroundColor = Color(0xFFFAE6E6),
        edgeColor = Color(0xFFED8B8B)
    ),

    IssueCircleData(
        issue = "Black Heads",
        percent = 43,
        backgroundColor = Color(0xFFFDFFA9),
        edgeColor = Color(0xFFDCDE8C)
    ),

)