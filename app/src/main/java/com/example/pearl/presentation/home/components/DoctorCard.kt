package com.example.pearl.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.pearl.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.model.doctors

@Composable
fun DoctorCard(
    doctor : Doctor,
    onCardClick : () -> Unit
){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            .wrapContentSize()
            .padding(5.dp)
            .clickable {
                onCardClick()
            }
    ){
        Column(
            modifier = Modifier.padding(ExtraSmallPadding2),
        ) {
            Image(
                painter = painterResource(id = doctor.image),
                contentDescription = null,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .size(76.dp, 80.dp)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            Text(text = doctor.name , fontSize = 8.sp , fontWeight = FontWeight(500))

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            Text(
                text = doctor.location,
                fontSize = 6.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    Modifier.size(7.dp, 6.dp)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding))

                Text(
                    text = doctor.rate,
                    fontSize = 6.sp,
                    fontWeight = FontWeight(600),
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Image(
                    painter = painterResource(id = R.drawable.medical_kit),
                    contentDescription = null,
                    Modifier.size(7.dp, 6.dp)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding))

                Text(
                    text = "${doctor.experience} years",
                    fontSize = 6.sp,
                    fontWeight = FontWeight(600),
                )

            }
        }
    }
}

@Composable
@Preview
fun DoctorCardPreview(){
    DoctorCard(doctors[0] , {})
}