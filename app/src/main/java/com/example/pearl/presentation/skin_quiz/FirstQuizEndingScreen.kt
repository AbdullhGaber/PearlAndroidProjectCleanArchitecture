package com.example.pearl.presentation.skin_quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.presentation.skin_quiz.components.InstructionBox

@Composable
fun FirstQuizEndingScreen(){
    Box(Modifier.background(Color.White)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "Analyze Skin Health",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(19.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                shape = RoundedCornerShape(20.dp),
            ){
                Text(
                    text = "Before we start, let's snap a photo of your lovely face. This will enhance your personalized skincare.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)
                )
            }

            Spacer(modifier = Modifier.height(42.dp))

            Text(
                text = "For more accurate results:-",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)
            )

            InstructionBox(instructionBoxDataList = instructionBoxDataList)

        }
    }
}

@Composable
@Preview
fun PreviewFirstQuizEndingScreen(){
    FirstQuizEndingScreen()
}