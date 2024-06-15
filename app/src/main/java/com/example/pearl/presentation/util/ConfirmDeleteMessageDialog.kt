package com.example.pearl.presentation.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.SecondaryButton


@Composable
fun ConfirmDeleteMessageDialog(
    onConfirm : () -> Unit,
    onDismiss : () -> Unit,
    message : String
){
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){

                Button(
                    onClick = { onConfirm() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFDD4D4D),
                    ),
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "Remove" , fontSize = 20.sp)
                }
                
                Spacer(modifier = Modifier.width(5.dp))

                SecondaryButton(
                    text = "Cancel",
                    onClick = { onDismiss() },
                    modifier = Modifier.weight(1f)
                )
            }
        },
        dismissButton = {
        },

        textContentColor = Color.Black,

        text = {
            Text(text = message , fontSize = 18.sp , fontWeight = FontWeight.Medium)
        },

    )
}

@Preview
@Composable
fun PreviewConfirmDeleteDialog(){
    ConfirmDeleteMessageDialog(onConfirm = { /*TODO*/ }, onDismiss = { /*TODO*/ }, message = "Are you sure you want to remove this product from your routine?")
}