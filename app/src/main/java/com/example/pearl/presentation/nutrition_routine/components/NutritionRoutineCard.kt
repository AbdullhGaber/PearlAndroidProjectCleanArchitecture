package com.example.pearl.presentation.nutrition_routine.components

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.pearl.R
import com.example.pearl.presentation.common.HomeButton
import com.example.pearl.presentation.nutrition_routine.NutritionRoutineBoxData
import com.example.pearl.presentation.nutrition_routine.nutritionRoutineBoxDataList

@Composable
fun NutritionRoutineCard(
    nutritionRoutineBoxData: NutritionRoutineBoxData,
    onClick : () -> Unit
){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .wrapContentSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.bg_nutrition_routine),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

            Row(
                Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = painterResource(id = nutritionRoutineBoxData.image),
                    contentDescription = null,
                    modifier = Modifier.size(96.dp)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding))

                   Column(
                       modifier = Modifier
                           .clip(RoundedCornerShape(10.dp))
                           .background(Color.White)
                           .padding(25.dp)
                           .wrapContentHeight()
                   ) {
                       Text(
                           text = nutritionRoutineBoxData.title,
                           fontSize = 12.sp,
                           fontWeight = FontWeight(600),
                           color = Color(0xFF000000),
                       )

                       Text(
                           text = nutritionRoutineBoxData.body,
                           fontSize = 9.sp,
                           fontWeight = FontWeight(400),
                           lineHeight = 11.92.sp,
                           color = Color(0xFF000000),
                       )

                       HomeButton(
                           text = "Explore",
                           onClick = {
                               onClick()
                           },
                           modifier = Modifier.align(End))
                   }
               }
   }
}

@Composable
@Preview
fun PreviewNutritionRoutineCard(){
    NutritionRoutineCard(nutritionRoutineBoxDataList[1] , {})
}