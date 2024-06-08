package com.example.pearl.presentation.authentication.sign_up.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.newsapp.presentation.Dimens
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState

@Composable
fun AgeTextField(
    modifier: Modifier = Modifier,
    label : String,
    authState : AuthState,
    authEvent: (AuthEvent) -> Unit
){
    OutlinedTextField(
        value = authState.age,
        onValueChange = {
            authEvent(AuthEvent.UpdateAge(it))
            authEvent(AuthEvent.ValidateAge)
        },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        shape = RoundedCornerShape(35.dp),
        keyboardActions = KeyboardActions(onNext = { /* Handle next action */ }),
        modifier = modifier
            .padding(vertical = 8.dp)
            .height(60.dp)
            .fillMaxWidth()
    )
}

@Composable
@Preview
fun PreviewAgeTextField(){
//    AgeTextField()
}