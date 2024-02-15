package com.example.pearl.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pearl.R

@Composable
fun BigCircleButton(
    @DrawableRes icon : Int,
    onClick : () -> Unit
){
    Box(modifier = Modifier
        .wrapContentSize()
        .clip(CircleShape)
        .background(Color.Black)
        .size(72.dp)
        .padding(10.dp)
        .clickable { onClick() }
    ){
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun PreviewBigCircleButton(){
    BigCircleButton(R.drawable.camera_button,{})
}