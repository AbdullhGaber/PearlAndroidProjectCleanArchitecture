package com.example.pearl.presentation.authentication.sign_up


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.R
import com.example.pearl.domain.model.UserGender
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.authentication.components.EmailTextField
import com.example.pearl.presentation.authentication.components.PasswordTextField
import com.example.pearl.presentation.authentication.sign_up.components.AgeTextField
import com.example.pearl.presentation.authentication.sign_up.components.FirstNameTextField
import com.example.pearl.presentation.authentication.sign_up.components.PhoneNumberTextField
import com.example.pearl.presentation.authentication.sign_up.components.LastNameTextField
import com.example.pearl.presentation.authentication.sign_up.components.RadioButtonWithLabel
import com.example.pearl.presentation.common.*
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.sign_in.components.CenteredTextBetweenTwoLines
import com.example.pearl.presentation.util.LoadingDialog


@Composable
fun SignUpScreen(
    authState: AuthState = AuthState(),
    authEvent: (AuthEvent) -> Unit = {},
    navigateToScreen : (String) -> Unit = {},
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

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.ExtraPadding)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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

        authState.nameErrorMessage?.let{
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.MediumPadding1, vertical = Dimens.ExtraSmallPadding)
        ){
            Text(text = "Gender" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)

            Row(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                RadioButtonWithLabel(
                    label = "Male",
                    selected = authState.gender.name == "MALE",
                    onClick = {
                        authEvent(AuthEvent.UpdateGender(UserGender.MALE))
                    }
                )

                RadioButtonWithLabel(
                    label = "Female",
                    selected = authState.gender.name == "FEMALE",
                    onClick = {
                        authEvent(AuthEvent.UpdateGender(UserGender.FEMALE))
                    }
                )
            }

            Text(text = "Email Address" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            EmailTextField(authState , authEvent)
            authState.emailErrorMessage?.let{
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            Text(text = "Phone Number" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            PhoneNumberTextField(authState , authEvent)

            Text(text = "Age" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)
            AgeTextField(
                label = "Enter your Age",
                authState = authState,
                authEvent = authEvent
            )
            authState.ageErrorMessage?.let{
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            Text(text = "Address" , fontWeight = FontWeight.ExtraBold , fontSize = 20.sp)

            PrimaryTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = "street",
                value = authState.street,
                onValueChange = {
                    authEvent(AuthEvent.UpdateStreet(it))
                    authEvent(AuthEvent.ValidateAddresses)
                }
            )

            Spacer(Modifier.height(5.dp))

            PrimaryTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = "state",
                value = authState.state,
                onValueChange = {
                    authEvent(AuthEvent.UpdateState(it))
                    authEvent(AuthEvent.ValidateAddresses)
                }
            )

            Spacer(Modifier.height(5.dp))

            PrimaryTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = "country",
                value = authState.country,
                onValueChange = {
                    authEvent(AuthEvent.UpdateCountry(it))
                    authEvent(AuthEvent.ValidateAddresses)
                }
            )

            authState.addressesErrorMessage?.let{
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

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

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        val context = LocalContext.current
        PrimaryButton(
            text = "Sign Up" ,
            onClick = {
                if(isInputsValid(authState)){
                         authEvent(AuthEvent.SendOTPMessage(context))
                         authEvent(AuthEvent.StartTimer)
                         navigateToScreen(Route.OTPScreen.route)
                }else{
                    authEvent(AuthEvent.ValidateInputs)
                }
            }
        )

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

private fun isInputsValid(authState: AuthState) =
    (authState.isValidPhone && authState.error == null &&
            authState.phoneNo.isNotBlank() && authState.firstName.isNotBlank() &&
            authState.lastName.isNotBlank() && authState.email.isNotBlank() &&
            authState.password.isNotBlank() && authState.age.isNotBlank()
            && authState.emailErrorMessage == null && authState.passwordErrorMessage == null
            && authState.addressesErrorMessage == null && authState.ageErrorMessage == null)

@Composable
@Preview
fun SignUpScreenPreview(){
   SignUpScreen()
}