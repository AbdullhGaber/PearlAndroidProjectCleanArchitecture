package com.example.pearl.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp

@Composable
fun OnBoardingForwardButton(
    onClick: () -> Unit,
    buttonSize: Dp = 76.dp,
    iconSize: Dp = 24.dp,
    backgroundColor: Color = Color.Black,
    iconColor: Color = Color.White
) {
    Box(
        modifier = Modifier
            .size(buttonSize)
            .padding(8.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(buttonSize)
                .background(
                    color = backgroundColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Right Arrow",
                tint = iconColor,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Preview
@Composable
fun CircularButtonPreview() {
    OnBoardingForwardButton(onClick = {})
}