package com.example.pearl.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.pearl.presentation.home.RoutineCardData
import com.example.pearl.presentation.home.routineCards

@Composable
fun RoutineCard(routineCard: RoutineCardData , modifier: Modifier = Modifier){
    Box(
        modifier = modifier
        .clip(RoundedCornerShape(10.dp))
        .background(color = routineCard.backgroundColor)
        .padding(5.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = routineCard.icon),
                contentDescription = null,
                modifier = Modifier.size(43.dp)
            )
            
            Spacer(modifier = Modifier.height(ExtraSmallPadding))
            
            Text(
                text = "Your Morning Routine",
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                color = if(routineCard.isNight) Color.White else Color.Black
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding))

            Text(
                text = "0/5",
                fontWeight = FontWeight.Medium,
                fontSize = 8.sp,
                color = if(routineCard.isNight) Color.White else Color(0xFF7F7F7F)
            )
        }
    }
}



@Composable
@Preview
fun RoutineCardPreview(){
    RoutineCard(routineCard = routineCards[1])
}