package com.example.pearl.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun PrimaryTextField(
    modifier: Modifier = Modifier,
    placeholder : String,
    enabled : Boolean = true,
    trailingIcon : @Composable () -> Unit = {}
){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        enabled = enabled,
        placeholder = { Text(placeholder) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        trailingIcon  = trailingIcon,
        shape = RoundedCornerShape(20.dp),
        keyboardActions = KeyboardActions(onNext = { /* Handle next action */ }),
        modifier = modifier
            .padding(vertical = 8.dp)
            .height(60.dp)
    )
}

@Composable
@Preview
fun PreviewPrimaryTextField(){
    PrimaryTextField(placeholder ="Enter name on card")
}
