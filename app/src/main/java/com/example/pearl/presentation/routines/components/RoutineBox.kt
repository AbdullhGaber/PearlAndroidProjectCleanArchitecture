package com.example.pearl.presentation.routines.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.presentation.routines.RoutineBoxData
import com.example.pearl.presentation.routines.routineBoxes

@Composable
fun RoutineBox(
    routineBoxData: RoutineBoxData
){
   Box(
       modifier = Modifier
           .padding(10.dp)
           .clip(RoundedCornerShape(10.dp))
           .background(routineBoxData.backgroundColor)
           .clickable {  },
   ){
       Row(Modifier
           .padding(horizontal = 10.dp, vertical = 20.dp)
           .fillMaxWidth()) {
           Image(
               painter = painterResource(id = routineBoxData.icon),
               contentDescription = null,
               modifier = Modifier
                   .clip(CircleShape)
                   .background(Color.White)
                   .padding(
                       ExtraSmallPadding2)
           )
           Spacer(modifier = Modifier.width(ExtraSmallPadding2))
           Column(Modifier.weight(1f)){
               Text(
                   text = routineBoxData.title,
                   fontWeight = FontWeight(500),
                   fontSize = 18.sp,
                   color = if(routineBoxData.isNight) Color.White else Color.Black
               )

               Spacer(modifier = Modifier.height(ExtraSmallPadding2))

               Text(
                   text = routineBoxData.time,
                   fontWeight = FontWeight(500),
                   fontSize = 12.sp,
                   color = if(routineBoxData.isNight) Color.White else Color(0xFF7F7F7F)
               )

               if(routineBoxData.number!=null){
                   Spacer(modifier = Modifier.height(MediumPadding1))
                   Text(
                       text = "0/${routineBoxData.number}",
                       fontWeight = FontWeight(400),
                       fontSize = 10.sp,
                       modifier = Modifier.align(CenterHorizontally),
                       color = if(routineBoxData.isNight) Color.White else Color(0xFF7F7F7F)
                   )
               }

           }
       }
   }
}

@Composable
@Preview
fun RoutineBoxPreview(){
    RoutineBox(routineBoxes[3])
}