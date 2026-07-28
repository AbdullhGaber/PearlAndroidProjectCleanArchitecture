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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pearl.design_system.theme.Dimens
import com.example.pearl.design_system.theme.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.authentication.AuthViewModel
import com.example.pearl.design_system.components.PrimaryButton
import com.example.pearl.design_system.components.CloseIconButton
import com.example.pearl.presentation.authentication.components.EmailTextField
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.util.ErrorDialog
import com.example.pearl.presentation.util.LoadingDialog

@Composable
fun ForgotPasswordByEmailScreen(
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
            onDismiss = { authEvent(AuthEvent.UpdateError(null)) }
        )
    }

    Box(modifier = Modifier.fillMaxSize()){
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

        Text(text = "Forgot Password" , fontWeight = FontWeight.ExtraBold , fontSize = 33.sp)

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(text = "Enter your email to send you an OTP" , fontWeight = FontWeight.Normal , fontSize = 13.sp)

        Spacer(modifier = Modifier.height(MediumPadding1))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding1, vertical = MediumPadding1)
        ){
            Text(text = "Email Address" , fontWeight = FontWeight.Medium , fontSize = 20.sp)
            EmailTextField(authState = authState , authEvent = authEvent)
            authState.emailErrorMessage?.let{
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "We will send you an OTP code to your email, then you can be able to change your password.",
                modifier = Modifier
                    .clickable { }
                    .padding(end = MediumPadding1),

                fontWeight = FontWeight.Normal ,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            val forgotPasswordAnnotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp
                    )
                ){
                    append("Don’t have access to this? ")
                }

                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp
                    )
                ){
                    append("Try with mobile number")
                }
            }

            Text(
                text = forgotPasswordAnnotatedString,
                modifier = Modifier
                    .clickable {
                        navigateToScreen(Route.ForgotPasswordByPhoneScreen.route)
                    }
                    .padding(end = MediumPadding1),

                fontWeight = FontWeight.ExtraBold ,
                fontSize = 13.sp
            )
            
            Spacer(modifier = Modifier.height(MediumPadding1))
        }

        PrimaryButton(
            text = "Send",
            onClick = {
                authEvent(AuthEvent.ResetPassword(
                    email = authState.email,
                    onSuccess = {
                        navigateToScreen(Route.ConfirmPasswordScreen.route)
                    }
                ))

            }
        )
    }
}

@Composable
@Preview
fun ForgetPasswordPreview(){
   ForgotPasswordByEmailScreen(authEvent = {} , navigateToScreen =  {} , navigateUp = {})
}
