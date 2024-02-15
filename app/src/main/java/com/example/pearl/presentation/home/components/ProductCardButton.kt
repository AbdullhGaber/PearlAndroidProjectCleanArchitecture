package com.example.pearl.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding

@Composable
fun ProductCardButton(
    text : String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = Modifier.wrapContentSize().clip(RoundedCornerShape(30.dp)).background(Color.Black)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 8.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 23.dp, top = 5.dp, end = 22.dp, bottom = 5.dp)
        )
    }
}

@Composable
@Preview
fun ProductCardButtonPreview(){
    ProductCardButton("Add to routine" , {})
}