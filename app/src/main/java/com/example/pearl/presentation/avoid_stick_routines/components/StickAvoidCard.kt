package com.example.pearl.presentation.avoid_stick_routines.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.presentation.avoid_stick_routines.StickAvoidRoutineData
import com.example.pearl.presentation.avoid_stick_routines.stickAvoidRoutineList

@Composable
fun StickAvoidCard(stickAvoidRoutineData: StickAvoidRoutineData){
    Box(Modifier.wrapContentSize().padding(5.dp).clip(RoundedCornerShape(10.dp)).background(Color.White)){
        Row(Modifier.padding(20.dp)) {
            Image(
                painter = painterResource(id = stickAvoidRoutineData.icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(Modifier.wrapContentSize()){
                Text(
                    text = stickAvoidRoutineData.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )

                Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding))

                Text(
                    text = stickAvoidRoutineData.body,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF7F7F7F),
                )

            }
        }
    }
}

@Composable
@Preview
fun PreviewStickAvoidCard(){
    StickAvoidCard(stickAvoidRoutineList[0])
}