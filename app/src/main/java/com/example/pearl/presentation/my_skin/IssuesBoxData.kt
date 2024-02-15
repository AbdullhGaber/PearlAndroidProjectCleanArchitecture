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
        issue = "Acne",
        description = "Occasional acne breakouts, including pimples and blackheads, can be managed with targeted skincare.",
        backgroundColor = Color(0xFFD0C5FF),
        edgeColor = Color(0xFFA3A3FF)
    ),

    IssuesBoxData(
        issue = "Pores",
        description = "Visible, enlarged pores that affect skin texture, often associated with excess oil production.",
        backgroundColor = Color(0x7E7EE97B),
        edgeColor = Color(0xFF7EE97B)
    ),

    IssuesBoxData(
        issue = "Wrinkles",
        description = "Minor signs of fine lines and wrinkles are visible; targeting smoother, more youthful-looking skin.",
        backgroundColor = Color(0xFFFAE6E6),
        edgeColor = Color(0xFFED8B8B)
    ),

    IssuesBoxData(
        issue = "Black Heads",
        description = "Presence of blackheads, small dark spots on the skin, focus on achieving a clearer complexion.",
        backgroundColor = Color(0xFFFDFFA9),
        edgeColor = Color(0xFFDCDE8C)
    ),

    )