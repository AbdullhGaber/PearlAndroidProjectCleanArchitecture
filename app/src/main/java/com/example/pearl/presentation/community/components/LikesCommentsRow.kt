package com.example.pearl.presentation.community.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.pearl.R

@Composable
fun LikesCommentsRow(modifier: Modifier = Modifier , postLikes : Int , postComments : Int){
    Row(
        modifier = modifier.background(Color.White),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.unfilled_heart_post),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

        Text(
            text = "$postLikes",
            fontSize = 10.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFFB3B3FB),
            letterSpacing = 0.25.sp,
        )

        Spacer(modifier = Modifier.width(12.dp))

        Image(
            painter = painterResource(id = R.drawable.comment_icon),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

        Text(
            text = "$postComments",
            fontSize = 10.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFFB3B3FB),
            letterSpacing = 0.25.sp,
        )

    }
}
@Composable
@Preview
fun PreviewLikesCommentsRow(){
    LikesCommentsRow(postLikes = 127, postComments = 24)
}