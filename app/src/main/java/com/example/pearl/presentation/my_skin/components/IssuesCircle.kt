package com.example.pearl.presentation.my_skin.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IssuesCircle(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFFAE6E6),
    edgeColor: Color = Color(0xFFED8B8B),
    edgeWidth: Float = 15.dp.value,
    percent : Int = 0
){
    Box(modifier = modifier
        .clip(CircleShape)
        .background(backgroundColor)
    ) {
        Text(
            text = percent.toString(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.Center)
        )

        Canvas(Modifier.size(70.dp)){
            val radius = size.minDimension / 2
            val centerX = size.width / 2
            val centerY = size.height / 2

            // Draw the main circle
            drawCircle(
                color = Color.Transparent,
                center = center,
                radius = radius,
                style = Stroke(width = edgeWidth, cap = Stroke.DefaultCap)
            )

            // Draw only 1/4 of the edge
                translate(left = centerX, top = centerY) {
                    drawArc(
                        color = edgeColor,
                        startAngle = 0f,
                        sweepAngle = (3.6 * percent).toFloat(),
                        useCenter = false,
                        topLeft = Offset(-radius, -radius),
                        size = Size(radius * 2, radius * 2),
                        style = Stroke(width = edgeWidth, cap = Stroke.DefaultCap)
                    )
                }
        }
    }
}

@Composable
@Preview
fun PreviewIssuesCircle(){
    IssuesCircle(percent = 25)
}