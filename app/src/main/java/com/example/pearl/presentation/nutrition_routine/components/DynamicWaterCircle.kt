package com.example.pearl.presentation.nutrition_routine.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R

@Composable
fun DynamicWaterCircle() {
    var sweepAngleAmount by remember{mutableStateOf(0f)}
    var waterAmountInML by remember{mutableStateOf(0)}

    val maxSweepAmount = 360f
    val minSweepAmount = 0f

    val sweepAngleAmountState by animateFloatAsState(
        targetValue = sweepAngleAmount,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    val waterAmountInMLState by animateIntAsState(
        targetValue = waterAmountInML,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    Column(
        modifier = Modifier.padding(16.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Canvas(
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp)
        ) {

            val increasedOpacityColor = Color(0xFF6767F7).copy(alpha = 0.9f)
            val decreasedOpacityColor = Color(0xFF6767F7).copy(alpha = 0.1f)

            val strokeWidth = 20f
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2 - strokeWidth

            drawArc(
                color = increasedOpacityColor,
                startAngle = 0f,
                sweepAngle = sweepAngleAmountState,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )

            drawArc(
                color = decreasedOpacityColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )


        }

        Spacer(modifier = Modifier.height(MediumPadding1))

        Row{

            // Decrease button
            val decreaseButtonEnabled = sweepAngleAmount > minSweepAmount
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
                    .clickable(enabled = decreaseButtonEnabled){
                            sweepAngleAmount -= 30f
                            waterAmountInML -= 250
                    }
                    .padding(5.dp),

            ) {
                Image(painter = painterResource(id = R.drawable.ic_remove), contentDescription = null)
            }

            Spacer(modifier = Modifier.width(MediumPadding1))

            Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "$waterAmountInMLState / 3000 ml ",
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.padding(ExtraSmallPadding))

                Text(
                    text = "1 cup",
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp,
                    color = Color(0xFF6767F7)
                )
            }
            
            Spacer(modifier = Modifier.width(MediumPadding1))


            // Increase button
            val increaseButtonEnabled = sweepAngleAmount < maxSweepAmount
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
                    .clickable(enabled = increaseButtonEnabled) {
                            sweepAngleAmount += 30f
                            waterAmountInML += 250
                    }
                    .padding(5.dp),
            ) {
                Image(painter = painterResource(id = R.drawable.ic_plus), contentDescription = null)
            }

        }





    }
}

@Preview
@Composable
fun PreviewDynamicWaterCircle() {
    DynamicWaterCircle()
}
