package com.example.pearl.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pearl.R

@Composable
fun PasswordTextField(
    label : String = "Enter your password",
    enabled : Boolean = true,
    text : String = ""
){

    var password by remember { mutableStateOf(if(!enabled) text else "") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        val visualTransformation: VisualTransformation =
            if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()

        OutlinedTextField(
            value = password,
            enabled = enabled,
            onValueChange = { password = it },
            label = { Text(label) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            shape = RoundedCornerShape(20.dp),
            keyboardActions = KeyboardActions(onDone = { /* Handle done action */ }),
            visualTransformation = visualTransformation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(60.dp),
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(48.dp)
                        .clickable {
                            passwordVisibility = !passwordVisibility
                        }
                ) {
                    val eyeIcon: Painter = if (passwordVisibility) {
                        painterResource(id = R.drawable.ic_visibility)
                    } else {
                        painterResource(id = R.drawable.ic_visibility_off)
                    }

                    Icon(painter = eyeIcon, contentDescription = "Toggle password visibility" , tint = Color.LightGray)
                }
            }
        )


    }
}

@Composable
@Preview
fun PasswordTextFieldPreview(){
    PasswordTextField()
}