package com.example.pearl.presentation.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pearl.R
import com.example.pearl.presentation.introduction.components.IntroductionButtonsFadeInAnimation
@Composable
fun IntroductionScreen(
    modifier: Modifier = Modifier
){
    Box(modifier = Modifier.fillMaxSize() ){
        Image(
            painter = painterResource(id = R.drawable.bg_screen_1) ,
            contentDescription = null,
            modifier = modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
    }

   Column(
       modifier = modifier.fillMaxSize(),
       verticalArrangement = Arrangement.SpaceBetween,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Image(
           painter = painterResource(id = R.drawable.logo) ,
           contentDescription = null,
           modifier = modifier.padding(vertical = 196.dp)
       )

       Column(
           modifier = Modifier.fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally
       ) {


           IntroductionButtonsFadeInAnimation()
       }

   }

}

@Preview
@Composable
fun IntroScreenPreview(){
    IntroductionScreen()
}