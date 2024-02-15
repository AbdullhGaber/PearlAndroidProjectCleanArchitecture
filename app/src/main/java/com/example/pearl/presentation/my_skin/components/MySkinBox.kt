package com.example.pearl.presentation.my_skin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R

@Composable
fun MySkinBox(
    text : String
){
    Box(Modifier
        .clip(RoundedCornerShape(100.dp))
        .background(Color(0xFFFAF8FF))
        .fillMaxWidth()
    ){
        Row(
            Modifier
                .padding(horizontal = 18.dp, vertical = 15.dp)
                .fillMaxWidth(),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ){
            Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Normal)

            Image(
                painter = painterResource(id = R.drawable.right_arrow),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
@Preview
fun PreviewMySkinBox(){
    MySkinBox(text = "Skin Type")
}