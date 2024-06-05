package com.example.pearl.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton

@Composable
fun DeleteAccountScreen(
    navigateToPrevious : () -> Unit
){
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
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .clickable {
                            navigateToPrevious()
                        },
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Delete Account",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
            
            Spacer(modifier = Modifier.height(51.dp))

            Row(Modifier.fillMaxWidth() , verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(text = "Salem Ahmed", fontSize = 14.sp , fontWeight = FontWeight.SemiBold)

            }

            Spacer(modifier = Modifier.height(38.dp))

            Text(text = "This will delete your account", fontSize = 14.sp , fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "This is a permanent action and will result in the removal of all your account data.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "What else you should know", fontSize = 14.sp , fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your personal information will be securely wiped from our database.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Any posts, interactions, or history associated with your account will be permanently erased.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Once confirmed, all your data will be permanently wiped from our system.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "This includes personal information, preferences, activity history, and any content associated with your account.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "After deletion, we cannot retrieve or restore any of your account data. This includes posts, settings, and user-specific information.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "If you've used third-party services through our platform, check their policies regarding account",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Contributions you've made to the community, such as comments or posts, will be permanently removed after deletion.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Account deletion is processed securely to protect your privacy. It is part of our commitment to data security.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )
        }
        
        PrimaryButton(
            text = "Delete Account",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
@Preview
fun PreviewDeleteAccountScreen(){
    DeleteAccountScreen({})
}