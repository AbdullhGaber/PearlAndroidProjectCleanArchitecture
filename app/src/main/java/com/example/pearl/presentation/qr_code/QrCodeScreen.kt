package com.example.pearl.presentation.qr_code

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R

@Composable
fun QrCodeScreen(){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(20.dp) , horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopStart),
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Qr Code",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            
            Text(text = "Scan Qr code" , fontSize = 24.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Scan the QR code for a prompt review of comprehensive skin analysis reports.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF7F7F7F)
            )
        }

        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(id = R.drawable.qr_code_scan),
                contentDescription = null,
            )

            Spacer(modifier = Modifier.height(78.dp))

            Text(
                text = "Share Qr code",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }

    }
}

@Composable
@Preview
fun PreviewQrCodeScreen(){
    QrCodeScreen()
}