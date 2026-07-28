package com.example.pearl.presentation.skin_quiz.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.presentation.skin_quiz.InstructionBoxData
import com.example.pearl.presentation.skin_quiz.instructionBoxDataList

@Composable
fun InstructionBox(
    instructionBoxDataList : List<InstructionBoxData>
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(20.dp),
    ){
        for(item in instructionBoxDataList){
            Row(
                Modifier.fillMaxWidth().padding(13.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    contentScale = ContentScale.FillBounds
                )

                Spacer(modifier = Modifier.width(8.dp))
                
                Text(text = item.text , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Composable
@Preview
fun PreviewInstructionBox(){
    InstructionBox(
        instructionBoxDataList
    )
}
