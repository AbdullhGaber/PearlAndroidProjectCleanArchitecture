package com.example.pearl.presentation.avoid_stick_routines

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import com.example.pearl.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.presentation.avoid_stick_routines.components.StickAvoidCard


@Composable
fun StickAvoidRoutineScreen(
    navigateToPrevious : () -> Unit
) {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
        Column(
            Modifier.fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Row(Modifier.padding(20.dp).fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier.
                        padding(5.dp).
                        clickable {
                            navigateToPrevious()
                        }
                    )

                    Text(
                        text = "Nutrition Routine",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Box(modifier = Modifier
                .wrapContentSize()
                .background(Color(0xFFF5FFF7))) {
                Column(
                    Modifier.padding(5.dp),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                       Image(
                           painter = painterResource(id = R.drawable.for_you_icon),
                           contentDescription = null,
                           modifier = Modifier.size(18.dp)
                       )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Stick to",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF5C944E),
                        )
                    }

                    for (stickAvoidData in stickAvoidRoutineList){
                        if(stickAvoidData.stickTo) 
                            StickAvoidCard(stickAvoidRoutineData = stickAvoidData)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier
                .wrapContentSize()
                .background(Color(0xFFFFF5F5))) {
                Column(
                    Modifier.padding(5.dp),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.avoid_icon),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Avoid",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFB22222),
                        )
                    }

                    for (stickAvoidData in stickAvoidRoutineList){
                        if(!stickAvoidData.stickTo)
                            StickAvoidCard(stickAvoidRoutineData = stickAvoidData)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewStickAvoidRoutine(){
  StickAvoidRoutineScreen({})
}