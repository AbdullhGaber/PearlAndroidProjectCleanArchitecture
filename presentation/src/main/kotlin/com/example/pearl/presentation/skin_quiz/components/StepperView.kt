package com.example.pearl.presentation.skin_quiz.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StepsProgressBar(
    modifier: Modifier = Modifier,
    progressPercent : Float,
    numberOfSteps: Int,
    currentStep: Int
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 0..numberOfSteps) {
            Step(
                modifier = Modifier.weight(1F),
                isComplete = step < currentStep,
                isCurrent = step == currentStep,
                progressPercent = progressPercent
            )
        }
    }
}

@Composable
fun Step(modifier: Modifier = Modifier, isComplete: Boolean, isCurrent: Boolean, progressPercent: Float) {
    val color = if (isComplete || isCurrent) Color.Black else Color.LightGray
    val innerCircleColor = if (isComplete) Color.Black else Color.LightGray

    Box(modifier = modifier.padding(horizontal = 3.dp)) {

        //Line
        LinearProgressIndicator(
            modifier = Modifier.align(Alignment.CenterStart),
            progress = if(isComplete) 1f else progressPercent,
            color = color,
            trackColor = Color.LightGray,
            strokeCap = StrokeCap.Square
        )
        //Circle
        Canvas(modifier = Modifier
            .size(15.dp)
            .align(Alignment.CenterEnd)
            .border(
                shape = CircleShape,
                width = 2.dp,
                color = color
            ),
            onDraw = {
                drawCircle(color = innerCircleColor)
            }
        )
    }
}

