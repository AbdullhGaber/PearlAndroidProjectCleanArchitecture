package com.example.pearl.presentation.authentication.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthFlowState
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.authentication.components.EmailTextField
import com.example.pearl.presentation.authentication.components.PasswordTextField
import com.example.pearl.presentation.authentication.sign_up.components.FirstNameTextField
import com.example.pearl.presentation.authentication.sign_up.components.PhoneNumberTextField
import com.example.pearl.presentation.authentication.sign_up.components.LastNameTextField
import com.example.pearl.presentation.common.*
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.sign_in.components.CenteredTextBetweenTwoLines
import com.example.pearl.presentation.util.LoadingDialog

@Composable
fun SignUpScreen(
    authState: AuthState,
    authFlowState: AuthFlowState,
    authEvent: (AuthEvent) -> Unit,
    navigateToScreen : (String) -> Unit,
){
    Box(modifier = Modifier.fillMaxSize() ){
        Image(
            painter = painterResource(id = R.drawable.sign_in) ,
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
    }

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.ExtraPadding)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingDialog(isLoading = authFlowState.isLoading)

        Text(text = "Sign Up" , fontWeight = FontWeight.ExtraBold , fontSize = 33.sp)

        Spacer(modifier = Modifier.height(Dimens.MediumPadding2))

        Text(text = "Create an account to continue" , fontWeight = FontWeight.Normal , fontSize = 13.sp)

        Row(Modifier.fillMaxWidth()) {
            FirstNameTextField(
                label = "First Name" ,
                modifier = Modifier.weight(1f) ,
                authState = authState,
                authEvent = authEvent
            )

            LastNameTextField(
                label = "Last Name" ,
                modifier = Modifier.weight(1f) ,
                authState = authState,
                authEvent = authEvent
            )
        }

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.MediumPadding1, vertical = Dimens.ExtraSmallPadding)
        ){
            Text(text = "Email Address" , fontWeight = FontWeight.Medium , fontSize = 20.sp)
            EmailTextField(authState , authEvent)

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            Text(text = "Phone Number" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            PhoneNumberTextField(authState , authEvent)

            Text(text = "Password" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            PasswordTextField(authState = authState , authEvent = authEvent)
        }

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        PrimaryButton(text = "Sign Up" , onClick = {
            navigateToScreen(Route.OTPScreen.route)
        })

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))


        val policyAnnotatedString = buildAnnotatedString {

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            ){
                append("By continuing, you agree with Pearl’s ")
            }

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 13.sp
                )
            ){
                append("terms and conditions ")
            }

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            ){
                append("and ")
            }

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 13.sp
                )
            ){
                append("privacy policy")
            }
        }

        val signInAnnotatedString = buildAnnotatedString {

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            ){
                append("Already have an account ? ")
            }

            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 13.sp
                )
            ){
                append("Sign in")
            }
        }

        Text(
            text = policyAnnotatedString,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = Dimens.MediumPadding1)
                .clickable {
                    navigateToScreen(Route.PrivacyPolicyScreen.route)
                }
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Text(
            text = signInAnnotatedString,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = Dimens.MediumPadding1)
                .clickable {
                    navigateToScreen(Route.SignInScreen.route)
                }
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        CenteredTextBetweenTwoLines("Or continue with")

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            SocialMediaButton(icon = R.drawable.google_logo , onClick = {})
            SocialMediaButton(icon = R.drawable.facebook_logo , onClick = {})
        }

        Spacer(modifier = Modifier.weight(0.5f))

    }
}

@Composable
@Preview
fun SignUpScreenPreview(){
//    SignUpScreen()
}