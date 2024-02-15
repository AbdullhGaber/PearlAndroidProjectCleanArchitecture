package com.example.pearl.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PasswordTextField
import com.example.pearl.presentation.common.PrimaryButton

@Composable
fun PasswordManagerScreen(){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        Column(modifier = Modifier.padding(20.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopStart),
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

            Text(text = "Current Password" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                enabled = false,
                text = "abc123123",
                label = ""
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Forgot Password",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF6767F7),
                modifier = Modifier.align(End)
            )

            Spacer(modifier = Modifier.height(37.dp))

            Text(text = "New Password" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                label = ""
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Confirm New Password" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                label = ""
            )
        }
        
        PrimaryButton(
            text = "Change Password",
            onClick = { /*TODO*/ },
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
    PasswordManagerScreen()
}