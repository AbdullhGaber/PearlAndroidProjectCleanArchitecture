package com.example.pearl.presentation.dermatologists.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.pearl.presentation.dermatologists.DermatologistCardData
import com.example.pearl.presentation.dermatologists.nearestDermatologistsCardData

@Composable
fun DermatologistCard(
    modifier: Modifier = Modifier,
    dermatologistCardData: DermatologistCardData
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Row(Modifier
            .padding(10.dp)
            .wrapContentSize()) {
          Image(
              painter = painterResource(id = dermatologistCardData.image),
              contentDescription = null,
              modifier = Modifier.size(88.dp,92.dp),
          )
            
          Spacer(modifier = Modifier.width(6.dp))

          Column{
              Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.padding(start = 16.dp)
              ) {
                  Box(
                      Modifier.
                      background(
                          color = Color(0xFFFAF8FF),
                          shape = RoundedCornerShape(size = 10.dp)
                      )
                  ){
                      Row(verticalAlignment = Alignment.CenterVertically){
                          Image(
                              painter = painterResource(id = R.drawable.verfied_doctor),
                              contentDescription = null
                          )

                          Spacer(modifier = Modifier.width(3.dp))

                          Text(
                              text = "Professional Doctor",
                              fontSize = 10.sp,
                              fontWeight = FontWeight(500),
                              color = Color(0xFF6767F7)
                          )
                      }
                  }
                  
                  Spacer(modifier = Modifier.width(22.dp))

                  Image(
                      painter = painterResource(id = if(dermatologistCardData.isFavorite) R.drawable.favorite_filled_heart else R.drawable.doctor_heart_favorite),
                      contentDescription = null,
                      contentScale = ContentScale.FillBounds,
                      modifier = Modifier
                          .size(25.dp)
                          .clickable { /*TODO*/ }
                  )
              }
              
              Spacer(modifier = Modifier.height(6.dp))

              Text(
                  text = "Dr. ${dermatologistCardData.name}",
                  fontSize = 14.sp,
                  fontWeight = FontWeight(500),
                  color = Color(0xFF000000),
              )

              Spacer(modifier = Modifier.height(6.dp))

              Text(
                  text = dermatologistCardData.location,
                  fontSize = 12.sp,
                  fontWeight = FontWeight(400),
                  color = Color(0xFF7F7F7F)
              )

              Spacer(modifier = Modifier.height(6.dp))

              Row{
                  Image(
                      painter = painterResource(id = R.drawable.medical_kit),
                      contentDescription = null,
                      contentScale = ContentScale.FillBounds,
                      modifier = Modifier.size(14.dp)
                  )

                  Spacer(modifier = Modifier.width(17.dp))

                  Text(
                      text = "${dermatologistCardData.experience} years",
                      fontSize = 8.sp,
                      fontWeight = FontWeight(600),
                      color = Color(0xFFD4D4D4),
                  )
              }
              
              Spacer(modifier = Modifier.width(6.dp))

              Box(
                  Modifier.
                  background(
                      color = Color(0xFFFAF8FF),
                      shape = RoundedCornerShape(size = 10.dp)
                  )
              ){
                  Row{
                      repeat(5){
                          Image(
                              painter = painterResource(id = R.drawable.star),
                              contentDescription = null,
                              modifier = Modifier.size(10.dp)
                          )
                      }
                      
                      Spacer(modifier = Modifier.width(4.dp))

                      Text(
                          text = dermatologistCardData.rate,
                          fontSize = 8.sp,
                          fontWeight = FontWeight(600),
                          color = Color(0xFF000000),
                      )

                      Spacer(modifier = Modifier.width(5.dp))

                      Image(
                          painter = painterResource(id = R.drawable.vertical_line),
                          contentDescription = null,
                          contentScale = ContentScale.FillBounds,
                      )

                      Spacer(modifier = Modifier.width(5.dp))

                      Text(
                          text = "${dermatologistCardData.reviewsNo} Reviews",
                          fontSize = 8.sp,
                          fontWeight = FontWeight(600),
                          color = Color(0xFFD4D4D4),
                      )
                  }
              }
           }
        }

        DoctorAppointmentButton(onClick = {})
    }
}

@Composable
@Preview
fun PreviewDermatologistCard(){
    DermatologistCard(dermatologistCardData = nearestDermatologistsCardData[1])
}