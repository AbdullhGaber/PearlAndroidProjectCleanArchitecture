package com.example.pearl.presentation.privacy_policy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R


@Composable
fun PrivacyPolicy(){
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopStart),
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Privacy & Policy",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(modifier = Modifier.height(39.dp))

            privacyPolicyData.forEachIndexed{ index, privacyPolicyData ->
                Text(
                    text = "${index + 1}. ${privacyPolicyData.title}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = privacyPolicyData.body,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF7F7F7F)
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewPrivacyPolicy(){
    PrivacyPolicy()
}

