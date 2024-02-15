package com.example.pearl.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.Dimens.SmallPadding
import com.example.pearl.R

@Composable
fun HomeButton(
    text : String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.
        clip(RoundedCornerShape(SmallPadding)).
        background(Color(0xFFF9F7FF)).
        clickable { onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(ExtraSmallPadding)
        ) {
            Text(text = text , fontSize = 8.sp , fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(ExtraSmallPadding))
            Image(painter = painterResource(id = R.drawable.right_arrow), contentDescription = null)
        }
    }
}

@Composable
@Preview
fun HomeButtonPreview(){
    HomeButton("see more" , {})
}