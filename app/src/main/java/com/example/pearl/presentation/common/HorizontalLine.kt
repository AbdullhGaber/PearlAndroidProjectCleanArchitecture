package com.example.pearl.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalLine(){
    Divider(color = Color(0xFFF2F2F2), thickness = 2.dp, modifier = Modifier.fillMaxWidth())
}

@Composable
@Preview
fun PreviewHorizontalLine(){
    HorizontalLine()
}