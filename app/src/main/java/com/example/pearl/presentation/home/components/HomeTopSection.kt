package com.example.pearl.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.pearl.R
import com.example.pearl.presentation.common.SkinCalenderView

@Composable
fun HomeTopSection(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .wrapContentSize()
            .padding(vertical = MediumPadding2)
    ){
        Column(
            Modifier
            .padding(MediumPadding1)
            .fillMaxWidth()
        ){
            Spacer(modifier = Modifier.height(25.dp))

            Row{
                Image(painter = painterResource(id = R.drawable.emoji_sun), contentDescription = null )

                Spacer(modifier = Modifier.width(ExtraSmallPadding))

                Text(
                    text = "Good morning, Salem",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000)
                )
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            SkinCalenderView(modifier = Modifier.padding(horizontal = ExtraSmallPadding2))
        }

    }
}

@Composable
@Preview
fun HomeTopSectionPreview(){
    HomeTopSection()
}