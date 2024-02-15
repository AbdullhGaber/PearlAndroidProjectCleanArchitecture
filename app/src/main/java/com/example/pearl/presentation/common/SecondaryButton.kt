package com.example.pearl.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondaryButton(
    text : String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF7F3FF) ,
            contentColor = Color.Black,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Gray
        ),
        modifier = modifier,
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(text = text , fontWeight = FontWeight.SemiBold , fontSize = 20.sp)
    }
}


@Composable
@Preview
fun SecondaryButtonPreview(){
    SecondaryButton(text = "Sign In" , onClick = {})
}