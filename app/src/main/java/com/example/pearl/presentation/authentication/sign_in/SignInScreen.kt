package com.example.pearl.presentation.authentication.sign_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
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
import com.example.newsapp.presentation.Dimens.ExtraPadding
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.authentication.components.EmailTextField
import com.example.pearl.presentation.common.PasswordTextField
import com.example.pearl.presentation.common.SocialMediaButton
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.sign_in.components.CenteredTextBetweenTwoLines
import com.example.pearl.presentation.util.LoadingDialog


@Composable
fun SignInScreen(
    authState : AuthState,
    authEvent : (AuthEvent) -> Unit,
    navigateToScreen : (String) -> Unit,
){
    LoadingDialog(isLoading = authState.isLoading)

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
            .padding(top = ExtraPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In" , fontWeight = FontWeight.ExtraBold , fontSize = 33.sp)

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(text = "Sign in to your account to continue" , fontWeight = FontWeight.Normal , fontSize = 13.sp)

        Spacer(modifier = Modifier.height(MediumPadding2))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding1, vertical = MediumPadding1)
        ){
            Text(text = "Email Address" , fontWeight = FontWeight.Medium , fontSize = 20.sp)
            EmailTextField(authState =  authState , authEvent = authEvent)
            authState.emailErrorMessage?.let{
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(text = "Password" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            PasswordTextField(authState = authState , authEvent = authEvent)
            authState.passwordErrorMessage?.let{
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = "Forgot your password ?",
            modifier = Modifier
                .clickable {
                    navigateToScreen(Route.ForgotPasswordByEmailScreen.route)
                }
                .align(End)
                .padding(end = MediumPadding1),

            fontWeight = FontWeight.ExtraBold ,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(MediumPadding2))

        PrimaryButton(
            text = "Sign In" ,
            onClick = {
                if(authState.emailErrorMessage == null &&
                    authState.passwordErrorMessage == null &&
                    authState.email.isNotBlank() && authState.password.isNotBlank()
                    ){
                    authEvent(AuthEvent.Login(authState.email , authState.password))
                    navigateToScreen(Route.PearlNavigation.route)
                }else{
                    authEvent(AuthEvent.ValidateInputs)
                }
            }
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        val signUpAnnotatedString = buildAnnotatedString {

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            ){
                append("Don’t have an account ")
            }

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 13.sp
                ),
            ){
                append("Sign up")
            }
        }

        Text(
            text = signUpAnnotatedString,
            modifier = Modifier
                .align(Start)
                .padding(horizontal = MediumPadding1)
                .clickable {
                    navigateToScreen(Route.SignUpScreen.route)
                }
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        CenteredTextBetweenTwoLines("Or continue with")

        Spacer(modifier = Modifier.height(MediumPadding1))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            SocialMediaButton(icon = R.drawable.google_logo , onClick = {})
            SocialMediaButton(icon = R.drawable.facebook_logo , onClick = {})
        }
    }
}

@Composable
@Preview
fun SignInScreenPreview(){
//    SignInScreen()
}