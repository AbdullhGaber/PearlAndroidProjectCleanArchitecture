package com.example.pearl.presentation.book_appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.pearl.presentation.nav_graph.Route

@Composable
fun MyAppointmentScreen(
    navigateToScreen : (String) -> Unit,
    navigateToPrevious : () -> Unit
){
    Box(
       modifier = Modifier
           .background(Color.White)
           .fillMaxSize()
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp) ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)){
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.
                    align(Alignment.TopStart).
                    clickable {
                          navigateToPrevious()
                    },
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "My Appointment",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )

            }

            Spacer(modifier = Modifier.height(31.dp))

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

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Scheduled Appointment",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(20.dp))

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

            Spacer(modifier = Modifier.height(20.dp))

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
                    text = "2:00 - 2:30 ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

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
                    text = "1 (30 minutes)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Appointment Info",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(19.dp))

            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFAF8FF)
                ),
                modifier = Modifier.padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)){
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .padding(5.dp)
                            .background(Color(0xFFFAF8FF))
                    ) {
                        Image(painter = painterResource(id = R.drawable.online_payment),
                            contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    Column() {
                        Text(
                            text = "Online Appointment",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Chatting and video call",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF7F7F7F)
                        )
                    }

                    Spacer(modifier = Modifier.width(48.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "150 LE",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Paid",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF2BB928)
                        )
                    }
                }
            }
        }

        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 10.dp, vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            PrimaryButton(text = "Message (Start at 2:00 PM)" , onClick = { /*TODO*/ } , modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(17.dp))

            Text(
                text = "Back to home",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable {
                    navigateToScreen(Route.HomeScreen.route)
                }
            )
        }
    }
}

@Composable
@Preview
fun PreviewMyAppointmentScreen(){
    MyAppointmentScreen({} , {})
}