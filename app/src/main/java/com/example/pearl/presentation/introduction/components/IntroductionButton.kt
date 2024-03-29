package com.example.pearl.presentation.introduction

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IntroductionButton(
    modifier: Modifier = Modifier,
    text : String,
    onClick : () -> Unit
){
    Button(
        onClick = onClick,
        modifier = modifier
            .size(150.dp, 60.dp)
            .padding(bottom = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black ,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Gray
        )
    ) {
        Text(text = text )
    }

}