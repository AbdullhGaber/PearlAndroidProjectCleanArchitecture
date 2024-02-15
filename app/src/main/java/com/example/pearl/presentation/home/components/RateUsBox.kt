package com.example.pearl.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.pearl.R

@Composable
fun RateUsBox(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
    ){
        Image(
            painter = painterResource(id = R.drawable.bg_rate_us),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )

        Row(Modifier.padding(5.dp)) {

            Image(
                painter = painterResource(id = R.drawable.rate_us_frame),
                contentDescription = null,
                modifier = Modifier.weight(1f).size(92.dp,68.dp)
            )

            Column(Modifier.weight(1f)) {
                Text(
                    text = "Rate Us",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600)
                )

                Spacer(modifier = Modifier.height(ExtraSmallPadding))

                Text(
                    text = "How can we improve?",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF7F7F7F)
                )

            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
@Preview
fun RateUsBoxPreview(){
    RateUsBox()
}