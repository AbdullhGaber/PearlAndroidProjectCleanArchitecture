package com.example.pearl.presentation.authentication.otp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.CloseIconButton
import com.example.pearl.presentation.authentication.components.OTPTextFields

@Composable
fun OTPScreen(

    otpInfo: OTPInfo
){
    Box(modifier = Modifier.fillMaxSize()){

        Box(modifier = Modifier.fillMaxSize() ){
            Image(
                painter = painterResource(id = R.drawable.sign_in) ,
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        CloseIconButton(modifier = Modifier
            .align(Alignment.TopStart)
            .padding(top = Dimens.MediumPadding1))

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


            OTPTextFields()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.MediumPadding1, vertical = Dimens.MediumPadding1)
            ){
                Text(
                    text = "4:59",
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )

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

                Text(
                    text = codeReceiverAnnotatedString,
                    modifier = Modifier
                        .clickable {
                           //resend otp code
                        }
                        .padding(end = Dimens.MediumPadding1),
                    fontWeight = FontWeight.ExtraBold ,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

            PrimaryButton(text = "Send" , onClick = {})
        }

    }
}

@Preview
@Composable
fun OTPPreview(){
    OTPScreen(otpInfo = otpInfoMap[OTPScreenType.PasswordEmail]!!)
}