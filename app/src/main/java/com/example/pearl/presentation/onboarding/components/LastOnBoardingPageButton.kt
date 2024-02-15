package com.example.pearl.presentation.onboarding.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LastOnBoardingPageButton(
    onClick: () -> Unit,
    buttonSize: Dp = 90.dp,
    iconSize: Dp = 24.dp,
    backgroundColor: Color = Color.White,
    iconColor: Color = Color.Black
){

    Button(
        onClick = onClick,
        modifier = Modifier.size(150.dp, 60.dp),
        colors =  ButtonDefaults.buttonColors(
            containerColor = Color.Black ,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Gray
        )
    ) {

        Text(text = "Get Started" , fontWeight = Bold)

        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Right Arrow",
            modifier = Modifier.size(iconSize)
        )
    }

}

@Preview
@Composable
fun LastOnBoardingPageButtonPreview() {
    LastOnBoardingPageButton(onClick = {})
}