package com.example.pearl.presentation.dermatologists

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton

@Composable
fun PaymentSuccessScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
            Text(
                text = "Payment",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.TopCenter).padding(20.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier.align(Alignment.TopEnd).padding(20.dp)
            )

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 60.dp , vertical = 20.dp)
            ) {

                Spacer(modifier = Modifier.height(35.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.step_3), contentDescription = null )

                    Spacer(modifier = Modifier.height(69.dp))

                    Image(painter = painterResource(id = R.drawable.done_successfully), contentDescription = null)

                    Spacer(modifier = Modifier.height(49.dp))

                    Text(text = "Payment Successful" , fontSize = 24.sp , fontWeight = FontWeight.SemiBold)

                    Text(
                        text = "You have successfully booked appointment with",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF8C8C8C),
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = "Dr. Mariam Zahran" , fontSize = 16.sp , fontWeight = FontWeight.SemiBold)

                }

                Spacer(modifier = Modifier.height(30.dp))

                Row{
                    Image(painter = painterResource(id = R.drawable.calender), contentDescription = null )
                    
                    Spacer(modifier = Modifier.width(14.dp))

                    Text(text = "October 22, 2023" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

                    Spacer(modifier = Modifier.width(36.25.dp))

                    Image(painter = painterResource(id = R.drawable.watch_timer), contentDescription = null )
                    
                    Spacer(modifier = Modifier.width(15.25.dp))

                    Text(text = "2 pm" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
                }

                Spacer(modifier = Modifier.height(33.dp))

                Row{
                    Image(painter = painterResource(id = R.drawable.time_30), contentDescription = null )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = "30 minutes" , fontSize = 14.sp , fontWeight = FontWeight.Medium)

                    Spacer(modifier = Modifier.width(71.3.dp))

                    Image(painter = painterResource(id = R.drawable.clarity_dollar_solid), contentDescription = null )

                    Spacer(modifier = Modifier.width(13.33.dp))

                    Text(text = "150 LE" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
                }


            }

        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 10.dp, vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            PrimaryButton(text = "View Appointment" , onClick = { /*TODO*/ } , modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(17.dp))

            Text(text = "Back to home" , fontSize = 18.sp , fontWeight = FontWeight.Medium)

        }
    }
}

@Preview
@Composable
fun PreviewPaymentSuccess(){
    PaymentSuccessScreen()
}