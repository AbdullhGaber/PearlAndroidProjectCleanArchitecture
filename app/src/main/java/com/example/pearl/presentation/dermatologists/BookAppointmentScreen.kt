package com.example.pearl.presentation.dermatologists

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
fun BookAppointmentScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(Modifier
            .fillMaxSize()
            .padding(20.dp)) {
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
                    text = "Book Appointment",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Image(
                painter = painterResource(id = R.drawable.step_0),
                contentDescription = null,
                modifier = Modifier.align(CenterHorizontally)
            )

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

            Spacer(modifier = Modifier.height(23.dp))

            Text(
                text = "Select Package",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(23.dp))

            Row(Modifier.fillMaxWidth() , Arrangement.SpaceBetween , Alignment.CenterVertically){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color(0xFFFAF8FF))
                            .padding(5.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.online_payment),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(10.dp))
                    
                    Column{
                        Text(
                            text = "Online Appointment",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Chatting and videocall",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7F7F7F)
                        )
                    }
                }

                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "150 LE",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "/30 min",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(Modifier.fillMaxWidth() , Arrangement.SpaceBetween , Alignment.CenterVertically){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color(0xFFFAF8FF))
                            .padding(5.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.inperson_payment),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column{
                        Text(
                            text = "In Person",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Visit the dactor",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7F7F7F)
                        )
                    }
                }

                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "200 LE",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "/30 min",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Day",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(25.dp))

            Row(Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),Arrangement.SpaceBetween
            ){
                Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "Today",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = "20 OCT",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF000000),
                    )
                }

                Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "Thu",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )

                    Text(
                        text = "22 OCT",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF000000),
                    )
                }

                Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "Sat",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )

                    Text(
                        text = "24 OCT",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF000000),
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Time",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),Arrangement.SpaceBetween
            ){
                Text(
                    text = "1:00 pm",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF000000)
                )

                Text(
                    text = "1:30 pm",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF000000),
                )

                Text(
                     text = "2:00 pm",
                     fontSize = 14.sp,
                     fontWeight = FontWeight.SemiBold,
                     color = Color(0xFF000000),
                )
            }
            
            Spacer(modifier = Modifier.height(51.dp))
            
            PrimaryButton(
                text = "Next",
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )

        }
    }
}

@Composable
@Preview
fun PreviewBookAppointmentScreen(){
    BookAppointmentScreen()
}