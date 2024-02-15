package com.example.pearl.presentation.common

import androidx.compose.foundation.background
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
fun WarningDialogBox(
    text : String,
    confirmText : String,
    cancelText : String,
    onConfirm : () -> Unit,
    onCancel : () -> Unit
){
    Box(modifier = Modifier.wrapContentSize().clip(RoundedCornerShape(15.dp)).background(Color.White)){
        Column(modifier = Modifier.padding(30.dp) , horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(17.dp))

            Row{
                SecondaryButton(text = "Cancel", onClick = { /*TODO*/ } , modifier = Modifier.weight(1f))

                Spacer(modifier = Modifier.width(7.dp))

                WarningButton(text = "Remove", onClick = { /*TODO*/ } , modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
@Preview
fun PreviewWarningDialogBox(){
    WarningDialogBox(
        text = "Remove doctor from your favorites?",
        confirmText = "Remove",
        cancelText = "Cancel",
        onCancel = {},
        onConfirm = {}
    )
}