package com.example.pearl.presentation.authentication.forgot_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.CloseIconButton
import com.example.pearl.presentation.common.PasswordTextField
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.util.ErrorDialog
import com.example.pearl.presentation.util.LoadingDialog

@Composable
fun ConfirmPassword(
    authState : AuthState = AuthState(),
    authEvent : (AuthEvent) -> Unit,
    navigateToScreen : (String) -> Unit,
    navigateUp : () -> Unit
){
    LoadingDialog(isLoading = authState.isLoading)
    if(authState.error != null){
        ErrorDialog(
            title = authState.error,
            message = "Try again",
            onDismiss = {
                authEvent(AuthEvent.UpdateError(null))
            },
        )
    }

    Box(modifier = Modifier.fillMaxSize() ){
        Image(
            painter = painterResource(id = R.drawable.sign_in) ,
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.MediumPadding2),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        CloseIconButton(
            modifier = Modifier.align(Start),
            onClick = {
                navigateUp()
            }
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(text = "Confirm Password" , fontWeight = FontWeight.ExtraBold , fontSize = 33.sp)

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(text = "Enter your new password you set from email" , fontWeight = FontWeight.Normal , fontSize = 13.sp)

        Spacer(modifier = Modifier.height(MediumPadding1))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding1, vertical = MediumPadding1)
        ){
            Text(text = "New Password" , fontWeight = FontWeight.Medium , fontSize = 20.sp)
            PasswordTextField(authState = authState , authEvent = authEvent)
            authState.passwordErrorMessage?.let{
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "This will be your new password so please don't forget it.",
                modifier = Modifier
                    .clickable { }
                    .padding(end = MediumPadding1),

                fontWeight = FontWeight.Normal ,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(MediumPadding1))
        }

        PrimaryButton(
            text = "Confirm",
            onClick = {
                authEvent(AuthEvent.Login(authState.email , authState.password))
                if(authState.error == null){
                    navigateToScreen(Route.PearlNavigation.route)
                }
            }
        )
    }
}

@Composable
@Preview
fun PreviewConfirmPassword(){
    ConfirmPassword(authEvent = {} , navigateToScreen =  {} , navigateUp = {})
}