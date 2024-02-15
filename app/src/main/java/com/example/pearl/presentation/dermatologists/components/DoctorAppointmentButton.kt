package com.example.pearl.presentation.dermatologists.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DoctorAppointmentButton(
    modifier: Modifier = Modifier,
    onClick : () -> Unit
){
    Box(modifier = modifier.
        padding(10.dp).
        clip(RoundedCornerShape(100.dp)).
        width(277.dp).
        height(33.dp).
        background(Color(0xFFF7F3FF)).
        clickable { onClick() }
    ){
        Text(
            text = "Make Appointment",
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF000000),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview
fun PreviewDoctorAppointmentButton(){
    DoctorAppointmentButton(onClick = {})
}