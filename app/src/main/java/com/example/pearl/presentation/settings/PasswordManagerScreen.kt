package com.example.pearl.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.authentication.components.EmailTextField
import com.example.pearl.presentation.common.NewPasswordTextField
import com.example.pearl.presentation.common.PasswordTextField
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.util.ErrorDialog
import com.example.pearl.presentation.util.PrimaryDialog

@Composable
fun PasswordManagerScreen(
    settingsScreensState: SettingsScreensState,
    settingsEvent: (SettingsEvent) -> Unit,
    authState : AuthState,
    authEvent: (AuthEvent) -> Unit,
    navigateToPrevious : () -> Unit
){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        if(settingsScreensState.showErrorDialog){
            ErrorDialog(
                title = settingsScreensState.error?.message ?: "Unknown Error",
                message = "Try again",
                onDismiss = {
                    settingsEvent(SettingsEvent.HideErrorDialog)
                }
            )
        }

        if(settingsScreensState.showSuccessDialog){
            PrimaryDialog(
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.done_successfully),
                        contentDescription = null
                    )
                },
                title ="Password updated successfully",
                message = "Keep it in somewhere safe",
                onDismiss = {
                    settingsEvent(SettingsEvent.HideSuccessDialog)
                }
            )
        }

        Column(modifier = Modifier.padding(20.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.
                    align(Alignment.TopStart).
                    clickable {
                        navigateToPrevious()
                    },
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Password Manager",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(text = "Email" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(8.dp))

            EmailTextField(
                authState = authState,
                authEvent = authEvent
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Current Password" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                label = "",
                authState = authState,
                authEvent = authEvent
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "New Password" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

            NewPasswordTextField(
                label = "",
                authState = authState,
                authEvent = authEvent
            )
        }
        
        PrimaryButton(
            text = "Change Password",
            onClick = {
                authEvent(AuthEvent.UpdatePassword(
                    email = authState.email,
                    password = authState.password,
                    newPassword = authState.newPassword,
                    onSuccess = {
                        settingsEvent(SettingsEvent.ShowSuccessDialog)
                    },
                    onFailure = {
                        settingsEvent(SettingsEvent.ShowErrorDialog(it))
                    }
                )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(BottomCenter)
                .padding(20.dp)
        )


    }
}
@Composable
@Preview
fun PreviewPasswordManager(){
    PasswordManagerScreen(
        settingsEvent = {},
        settingsScreensState = SettingsScreensState(),
        authEvent = {},
        authState = AuthState(),
        navigateToPrevious = {}
    )
}