package com.example.pearl.presentation.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton

@Composable
fun AccessLocationScreen(){

    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(painter = painterResource(id = R.drawable.ic_location), contentDescription = null )

            Spacer(modifier = Modifier.height(MediumPadding2))

            Text(text = "What is your location ?" , fontWeight = FontWeight.Medium , fontSize = 24.sp )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "We need to know your location in order to suggest nearby dermatologists",
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            PrimaryButton(text = "Allow Location Access" , onClick = {})

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(text = "Enter Location Manually" , fontWeight = FontWeight.Medium , fontSize = 16.sp )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
        ) {
            Text(
                text = "Skip",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier.clickable { }.padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun AccessLocationScreenPreview(){
    AccessLocationScreen()
}