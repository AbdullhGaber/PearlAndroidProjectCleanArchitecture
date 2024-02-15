package com.example.pearl.presentation.onboarding.components

import androidx.annotation.ColorInt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    modifier : Modifier = Modifier ,
    selectedPageIdx : Int,
    pagesSize : Int = 3,
    @ColorInt selectedColor : Color = Color.White,
    @ColorInt unSelectedColor : Color = Color.Gray,
){
    Row(
        modifier = modifier ,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        repeat(pagesSize){ pageIdx ->
            Box(
                modifier = modifier
                    .size(if(pageIdx == selectedPageIdx) 23.dp else 15.dp,11.dp)
                    .padding(horizontal = 2.dp)
                    .clip(if (pageIdx == selectedPageIdx) RoundedCornerShape(50) else CircleShape)
                    .background(color = if (pageIdx == selectedPageIdx) selectedColor else unSelectedColor)
            )
        }
    }
}

@Composable
@Preview
fun PageIndicatorPreview(){
    PageIndicator(selectedPageIdx = 1)
}