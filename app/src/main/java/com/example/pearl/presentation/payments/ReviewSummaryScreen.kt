package com.example.pearl.presentation.payments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.example.pearl.presentation.common.HorizontalLine
import com.example.pearl.presentation.common.PrimaryButton

@Composable
fun ReviewSummaryScreen(
    navigateToPrevious : () -> Unit,
    navigateToScreen : (String) -> Unit
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(
            Modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            Box(Modifier.fillMaxWidth()){
               Image(
                   painter = painterResource(id = R.drawable.arrow_back),
                   contentDescription = null,
                   modifier = Modifier.align(Alignment.TopStart)
               ) 
                
                Text(
                    text = "Review Summary",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Image(
                painter = painterResource(id = R.drawable.step_2),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(46.dp))

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFFFAF8FF))
                ){
                    Image(
                        painter = painterResource(id = R.drawable.doctor_1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(90.dp, 110.dp)
                            .align(Alignment.Center),
                        contentScale = ContentScale.FillBounds
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column{
                    Text(
                        text = "Dr. Mariam Zahran",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )

                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.dermatologist_location),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "El Mansoura, El Gaish St",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7F7F7F),
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(7.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Date",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "October 22, 2023",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Package",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "Online Appointment",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Time",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "2:00 - 2:30",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Duration",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "30 minutes",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(21.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Amount",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "150 LE",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Duration (30 minutes)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "1 x 150 LE",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Duration",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "30 minutes",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Total",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )

                Text(
                    text = "150 LE",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){

                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.visa), contentDescription = null)

                    Spacer(modifier = Modifier.width(9.dp))

                    Text(
                        text = "Visa",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF7F7F7F)
                    )

                }

                Text(
                    text = "Change",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF6767F7),
                    modifier = Modifier.clickable {
                        /*TODO*/
                    }
                )
            }
        }
        
        PrimaryButton(
            text = "Pay Now",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .align(
                    Alignment.BottomCenter
                )
                .padding(horizontal = 10.dp)
        )


    }
}

@Composable
@Preview
fun PreviewReviewSummaryScreen(){
    ReviewSummaryScreen({},{})
}