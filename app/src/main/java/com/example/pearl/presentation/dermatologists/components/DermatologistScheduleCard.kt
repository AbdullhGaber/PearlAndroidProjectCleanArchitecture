package com.example.pearl.presentation.dermatologists.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.pearl.presentation.common.HorizontalLine
import com.example.pearl.presentation.common.PearlSwitch
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.SecondaryButton
import com.example.pearl.presentation.dermatologists.DermatologistScheduleCardData
import com.example.pearl.presentation.dermatologists.dermatologistsSchedule

@Composable
fun DermatologistScheduleCard(
    modifier : Modifier = Modifier,
    dermatologistScheduleCardData: DermatologistScheduleCardData
){
    Card(
        modifier = modifier
            .width(330.dp)
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(20.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ){
        Column(modifier = Modifier.padding(10.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dermatologistScheduleCardData.date,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )

                Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Center){
                    Text(
                        text = "Remind me",
                        fontSize = 9.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F),
                    )

                    Spacer(Modifier.width(4.dp))

                    PearlSwitch()
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(14.dp))

            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = dermatologistScheduleCardData.image),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp,100.dp)
                )

                Column(){

                    Text(
                        text = dermatologistScheduleCardData.doctorName,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.dermatologist_location),
                            contentDescription = null,
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = dermatologistScheduleCardData.location,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7F7F7F)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.booking_card),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "Booking ID: ",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7F7F7F),
                        )

                        Text(
                            text = dermatologistScheduleCardData.bookingID,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6767F7),
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Divider(color = Color(0xFFF2F2F2), thickness = 2.dp, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(14.dp))

            Row{
                SecondaryButton(text = "Cancel" , onClick = {} , modifier = Modifier.weight(1f))

                PrimaryButton(text = "Reschedule" , onClick = {} , modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
@Preview
fun PreviewDermatologyScheduleCard(){
    DermatologistScheduleCard(
        dermatologistScheduleCardData = dermatologistsSchedule[1]
    )
}