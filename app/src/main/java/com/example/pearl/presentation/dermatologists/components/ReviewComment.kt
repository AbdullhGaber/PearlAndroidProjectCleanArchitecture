package com.example.pearl.presentation.dermatologists.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R

@Composable
fun ReviewComment(){
    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFFAF8FF))
    ){
        Column(Modifier.padding(10.dp)) {
            Text(
                text = "Merna",
                fontSize = 12.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(3.dp))

            Row{
                repeat(5){
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier.size(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Dr. Mariam's expertise and personalized care transformed my skin, grateful for her outstanding dermatological support!",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )
        }
    }
}

@Composable
@Preview
fun PreviewReviewComment(){
    ReviewComment()
}