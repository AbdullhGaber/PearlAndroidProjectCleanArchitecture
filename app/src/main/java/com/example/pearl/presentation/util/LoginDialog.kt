package com.example.pearl.presentation.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.authentication.components.EmailTextField
import com.example.pearl.presentation.common.PasswordTextField
import com.example.pearl.presentation.common.PrimaryButton


@Composable
fun LoginDialog(
    authState: AuthState,
    authEvent: (AuthEvent) -> Unit,
    onConfirm : () -> Unit,
    onDismiss : () -> Unit,
){
    AlertDialog(
        onDismissRequest = { onDismiss() },

        confirmButton = {
                Column{

                    EmailTextField(authState = authState  , authEvent = authEvent )

                    Spacer(modifier = Modifier.height(5.dp))

                    PasswordTextField(authState = authState , authEvent = authEvent )

                    Spacer(modifier = Modifier.height(10.dp))

                    Box{
                        PrimaryButton(
                            text = "Login",
                            onClick = { onConfirm() },
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth()
                        )
                    }
                }
        },

        textContentColor = Color.Black,

        text = {
            Column {
                Text(text = "This operation is sensitive please enter your email and password to confirm your request" , fontSize = 18.sp , fontWeight = FontWeight.Medium)

            }
        },
    )
}

@Preview
@Composable
fun PreviewLoginDialog(){
    LoginDialog(authState = AuthState(), authEvent = {}, onConfirm = { /*TODO*/ }, onDismiss = { /*TODO*/ })
}