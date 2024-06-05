package com.example.pearl.presentation.authentication.change_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.CloseIconButton
import com.example.pearl.presentation.authentication.components.PasswordTextField

@Composable
fun ChangePasswordScreen(
    authState : AuthState ,
    authEvent: (AuthEvent) -> Unit,
    navigateToScreen : (String) -> Unit,
    navigateUp : () -> Unit
){

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
            .padding(top = Dimens.ExtraPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CloseIconButton(
            modifier = Modifier.align(Start),
            onClick = {
                navigateUp()
            }
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Text(text = "Change Password" , fontWeight = FontWeight.ExtraBold , fontSize = 33.sp)

        Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))

        Text(text = "Enter a new password to continue" , fontWeight = FontWeight.Normal , fontSize = 13.sp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.MediumPadding1, vertical = Dimens.MediumPadding1)
        ){

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            Text(text = "New Password" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            PasswordTextField(
                authState = authState,
                authEvent = authEvent
            )

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            Text(text = "Confirm New Password" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            PasswordTextField(
                "Re-enter your password ",
                authEvent = authEvent,
                authState = authState
            )
        }

        PrimaryButton(text = "Send" , onClick = {})
    }
}

@Composable
@Preview
fun ChangePasswordPreview(){
//    ChangePasswordScreen()
}
