package com.example.pearl.presentation.authentication.otp


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.CloseIconButton
import com.example.pearl.presentation.authentication.components.OTPTextField
import com.example.pearl.presentation.util.ErrorDialog
import com.example.pearl.presentation.util.LoadingDialog

@Composable
fun OTPScreen(
    otpInfo: OTPInfo,
    authEvent : (AuthEvent) -> Unit,
    authState: AuthState = AuthState(),
    navigateToQuizScreen : () -> Unit,
    navigateUp : () -> Unit
){
    if(authState.error != null){
        ErrorDialog(
            title = authState.error,
            message = "Try again",
            onDismiss = {
                authEvent(AuthEvent.UpdateError(null))
            }
        )
    }

    LoadingDialog(isLoading = authState.isLoading)

    Box(modifier = Modifier.fillMaxSize()){
        Box(modifier = Modifier.fillMaxSize() ){
            Image(
                painter = painterResource(id = R.drawable.sign_in) ,
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        CloseIconButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = Dimens.MediumPadding1),
            onClick = {
                navigateUp()
                authEvent(AuthEvent.ResetTimer)
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = Dimens.MediumPadding2, horizontal = Dimens.MediumPadding2),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Spacer(modifier = Modifier.height(Dimens.MediumPadding2))

            Text(text = otpInfo.title , fontWeight = FontWeight.ExtraBold , fontSize = 33.sp)

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            Text(
                text = otpInfo.subTitle,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )

            OTPTextField(otpSize = 5 , onFilled = {
                authEvent(AuthEvent.SaveOTPCode(it))
            })

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.MediumPadding1, vertical = Dimens.MediumPadding1)
            ){
                Text(
                    text =String.format("%02d:%02d", authState.timeInSeconds / 60, authState.timeInSeconds % 60),
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
                Log.e("Timer" , "seconds : ${authState.timeInSeconds}")

                Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

                Text(
                    text = otpInfo.info,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

                val codeReceiverAnnotatedString = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            fontSize = 13.sp
                        )
                    ){
                        append("Didn't receive a code ? ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp
                        )
                    ){
                        append("Send again")
                    }
                }

                val context = LocalContext.current
                if(authState.timeInSeconds == 0){
                    Text(
                        text = codeReceiverAnnotatedString,
                        modifier = Modifier
                            .clickable {
                                authEvent(AuthEvent.SendOTPMessage(context))
                                authEvent(AuthEvent.ResetTimer)
                                authEvent(AuthEvent.StartTimer)
                            }
                            .padding(end = Dimens.MediumPadding1),
                        fontWeight = FontWeight.ExtraBold ,
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            PrimaryButton(
                text = "Verify" ,
                onClick = {
                authEvent(AuthEvent.VerifyOTPCode(
                    onSuccess = {
                        authEvent(AuthEvent.SignUp)
                        navigateToQuizScreen()
                    },
                    onFailure = {
                        authEvent(AuthEvent.UpdateError(Exception("OTP code is not correct !")))
                    }
                ))
            })
        }
    }
}

@Preview
@Composable
fun OTPPreview(){
   OTPScreen(
       otpInfo = otpInfoMap[OTPScreenType.PasswordEmail]!!,
       navigateToQuizScreen = {},
       authEvent = {},
       navigateUp = {}
   )
}