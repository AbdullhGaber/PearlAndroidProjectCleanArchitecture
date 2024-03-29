package com.example.pearl.presentation.authentication.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState

@Composable
fun EmailTextField(
    authState : AuthState,
    authEvent : (AuthEvent) -> Unit
){

    OutlinedTextField(
        value = authState.email,
        onValueChange = { authEvent(AuthEvent.UpdateEmailField(it)) },
        label = { Text("Enter Your Email") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        shape = RoundedCornerShape(20.dp),
        keyboardActions = KeyboardActions(onNext = { /* Handle next action */ }),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(60.dp)
    )
}

@Composable
@Preview
fun EmailTextFieldPreview(){
//    EmailTextField()
}