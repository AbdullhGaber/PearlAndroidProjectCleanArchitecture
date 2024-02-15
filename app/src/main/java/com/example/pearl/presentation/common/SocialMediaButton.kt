package com.example.pearl.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pearl.R

@Composable
fun SocialMediaButton(
    @DrawableRes icon : Int,
    onClick : () -> Unit
){
    IconButton(
        onClick = onClick,
       modifier = Modifier
                .size(64.dp)
                .padding(8.dp)
                .background(color = Color(0xF4F4F4), shape = CircleShape),
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}

@Composable
@Preview
fun SocialMediaButtonPreview(){
    SocialMediaButton(onClick = {} , icon = R.drawable.google_logo)
}
