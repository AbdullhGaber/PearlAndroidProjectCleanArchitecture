package com.example.pearl.presentation.introduction.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FadeInAnimation(
    content : @Composable () -> Unit,
){
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Box{
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                initialOffsetY = { 350 },
                animationSpec = tween(durationMillis = 1000 , delayMillis = 3000)
            ) + fadeIn(),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
               content()
        }
    }
}