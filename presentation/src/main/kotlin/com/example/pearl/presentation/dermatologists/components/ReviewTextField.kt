package com.example.pearl.presentation.dermatologists.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ReviewTextField() {
    var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            label = {
                Text(
                    text = "Add Review",
                    fontSize = 18.sp,
                    color = Color(0xFF7F7F7F),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            },
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF7F7F7F))
                .height(120.dp),
            textStyle = TextStyle(color = Color.White),
        )

}

@Preview
@Composable
fun PreviewReviewTextField() {
    ReviewTextField()
}
