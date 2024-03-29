package com.example.pearl.presentation.skin_quiz

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class InstructionBoxData(
   @DrawableRes val icon : Int,
    val text : String
)

val instructionBoxDataList = listOf(
    InstructionBoxData(
        icon = R.drawable.bright_instruction_box,
        text = "Ensure bright light source in front of you."
    ),

    InstructionBoxData(
        icon = R.drawable.face_instruction_box,
        text = "No hair on your forehead and face."
    ),

    InstructionBoxData(
        icon = R.drawable.glasses_instruction_box,
        text = "Remove glasses."
    ),

    InstructionBoxData(
        icon = R.drawable.brush_instruction_box,
        text = "Refrain from wearing makeup or any other products."
    )
)