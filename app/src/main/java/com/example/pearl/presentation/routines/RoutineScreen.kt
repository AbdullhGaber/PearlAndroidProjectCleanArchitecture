package com.example.pearl.presentation.routines

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.routines.components.RoutineBox

@Composable
fun RoutineScreen(){
    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Column(Modifier
            .fillMaxSize()
            .padding(ExtraSmallPadding)
        ) {
            Row(Modifier.padding(MediumPadding1).fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                    )

                    Text(
                        text = "Routines",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            for (routineBox in routineBoxes){
                RoutineBox(routineBoxData = routineBox)
            }
        }
    }
}

@Preview
@Composable
fun RoutineScreenPreview(){
    RoutineScreen()
}