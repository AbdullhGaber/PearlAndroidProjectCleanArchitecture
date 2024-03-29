package com.example.pearl.presentation.authentication.sign_up.components

import androidx.compose.foundation.layout.Row
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
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState

@Composable
fun FirstNameTextField(
    modifier: Modifier = Modifier ,
    label : String,
    authState : AuthState,
    authEvent: (AuthEvent) -> Unit
){

    OutlinedTextField(
        value = authState.firstName,
        onValueChange = { authEvent(AuthEvent.UpdateFirstNameField(it)) },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        shape = RoundedCornerShape(35.dp),
        keyboardActions = KeyboardActions(onNext = { /* Handle next action */ }),
        modifier = modifier
            .padding(vertical = 8.dp , horizontal = MediumPadding1)
            .height(60.dp)
    )
}

@Composable
@Preview
fun FirstNameTextFieldPreview(){
   Row(Modifier.fillMaxWidth()) {
//       NameTextField(label = "First Name" , modifier = Modifier.weight(1f))
//       NameTextField(label = "Last Name" , modifier = Modifier.weight(1f))
   }
}