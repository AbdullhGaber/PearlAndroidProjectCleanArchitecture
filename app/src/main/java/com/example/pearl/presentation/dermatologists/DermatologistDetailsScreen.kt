package com.example.pearl.presentation.dermatologists

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.pearl.presentation.dermatologists.components.ReviewComment
import com.example.pearl.presentation.dermatologists.components.ReviewTextField
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.model.doctors

@Composable
fun DermatologistDetailsScreen(
    doctor : Doctor,
    navigateToPrevious : () -> Unit,
    navigateToScreen : () -> Unit
){
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
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
                    text = "Dermatologist Details",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )

                Image(
                    painter = painterResource(id = R.drawable.doctor_heart_favorite),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp),
                    contentScale = ContentScale.FillBounds
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
                        painter = painterResource(id = doctor.image),
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
                        text = doctor.name,
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
                            text = doctor.location,
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

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                repeat(3){ index ->
                    val rowData = dermatologistDetailsIcon[index]

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 34.dp)
                    ) {
                        Image(painter = painterResource(id = rowData.icon ), contentDescription = null )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "${rowData.number}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF6767F7)
                        )

                        Spacer(modifier = Modifier.height(1.dp))

                        Text(
                            text = rowData.text,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7F7F7F)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "About",
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = doctor.description,
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Working Hours ",
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalLine()

            repeat(3){
                Row(Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp) , Arrangement.SpaceBetween){
                    Text(
                        text = "Saturday ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )

                    Text(
                        text = "12 pm : 10 pm ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7F7F7F)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Address",
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(15.dp))

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

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.dummy_map),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .height(300.dp)
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Reviews",
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalLine()

            Spacer(modifier = Modifier.height(10.dp))

            Row(Modifier.fillMaxWidth() , Arrangement.SpaceBetween){
                Text(
                    text = "Tap to Rate:",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF7F7F7F)
                )

                Row{
                    repeat(5){
                        Image(
                            painter = painterResource(id = R.drawable.unfilled_rate_star),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            ReviewTextField()

            Spacer(modifier = Modifier.height(10.dp))

            ReviewComment()

            ReviewComment()
            
            PrimaryButton(
                text = "Book Appointment",
                onClick = { navigateToScreen() },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
        }
    }
}

@Composable
@Preview
fun PreviewDermatologistDetailsScreen(){
    DermatologistDetailsScreen(doctors[0] , {} , {})
}