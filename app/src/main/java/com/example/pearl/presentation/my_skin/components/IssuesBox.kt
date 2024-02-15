package com.example.pearl.presentation.my_skin.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IssuesBox(
    modifier: Modifier = Modifier,
    background : Color,
    borderColor : Color,
    content : @Composable () -> Unit
){
    Box(
        modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .background(background)
        .border(BorderStroke(3.dp, borderColor), shape = RoundedCornerShape(8.dp))
    ){
            content()
    }
}

@Composable
@Preview
fun PreviewIssuesBox(){
    IssuesBox(background = Color(0xFFD0C5FF), borderColor = Color(0xFFA3A3FF)) {
        Column(
            Modifier.padding(horizontal = 16.dp , vertical = 8.dp)
        ){
            Text(text = "Acne" , fontSize = 14.sp , fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Occasional acne breakouts, including pimples and blackheads, can be managed with targeted skincare.",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}