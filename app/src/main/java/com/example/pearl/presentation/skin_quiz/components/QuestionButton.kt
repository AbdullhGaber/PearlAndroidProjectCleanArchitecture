package com.example.pearl.presentation.skin_quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
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
import com.example.pearl.presentation.skin_quiz.QuestionEvent

@Composable
fun QuestionButton(
    modifier: Modifier = Modifier,
    text : String,
    background : Color,
    onClick : () -> Unit
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .background(background)
            .padding(horizontal = 22.dp, vertical = 16.dp)
            .clickable {
                onClick()
            }
    ){
        Text(text = text  , fontSize = 16.sp , fontWeight = FontWeight.Normal)
    }
}

@Composable
@Preview
fun PreviewQuestionButton(){
    QuestionButton(text = "" , background = Color.White){}
}