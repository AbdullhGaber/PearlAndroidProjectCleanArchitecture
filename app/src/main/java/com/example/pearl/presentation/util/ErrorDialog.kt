package com.example.pearl.presentation.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.R

@Composable
fun ErrorDialog(title: String, message: String, onDismiss: () -> Unit) {

    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Box(Modifier.fillMaxWidth()){
                PrimaryButton(
                    text = "Dismiss",
                    onClick = { onDismiss() },
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
        },
        titleContentColor = colorResource(id = R.color.error),
        textContentColor = Color.Black,
        title = {
            Text(text = title , fontWeight = FontWeight.Bold)
        },
        text = {
            Text(text = message)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewErrorDialog(){
    ErrorDialog(title = "Wrong Email Format", message = "Enter a valid email" , onDismiss = {})
}