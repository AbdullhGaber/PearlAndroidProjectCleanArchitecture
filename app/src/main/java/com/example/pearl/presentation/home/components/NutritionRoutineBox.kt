package com.example.pearl.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.pearl.R
import com.example.pearl.presentation.common.HomeButton

@Composable
fun NutritionRoutineBox(
    modifier : Modifier = Modifier,
    onButtonClick : () -> (Unit)
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(0xFFF0FFF3))
            .wrapContentSize()
            .padding(10.dp)
    ){
        Row(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.nutrition_routine),
                contentDescription = null,
            )

            Spacer(modifier = Modifier.width(ExtraSmallPadding))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color.White)
                    .padding(5.dp)
            ){
                Column(modifier = Modifier.padding(ExtraSmallPadding)) {
                    Text(
                        text = "Nourish Your Skin",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )

                    Spacer(modifier = Modifier.height(ExtraSmallPadding))

                    Text(
                        text = "Discover how the right nutrients can enhance your skin's natural beauty.",
                        fontSize = 9.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )

                    Spacer(modifier = Modifier.height(ExtraSmallPadding))

                    HomeButton(
                        text = "Explore",
                        onClick = { onButtonClick() },
                        modifier = Modifier.align(End))
                }
            }
        }
    }
}

@Composable
@Preview
fun NutritionRoutineBoxPreview(){
//    NutritionRoutineBox()
}