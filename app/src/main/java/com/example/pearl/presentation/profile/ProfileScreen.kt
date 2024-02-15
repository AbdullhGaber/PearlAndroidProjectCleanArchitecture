package com.example.pearl.presentation.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
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
import com.example.pearl.presentation.common.PrimaryTextField

@Composable
fun ProfileScreen(){
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(scrollState)
    ){
        Column(modifier = Modifier.padding(20.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopStart),
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

            Spacer(modifier = Modifier.height(36.dp))

            Box(
                modifier = Modifier.align(CenterHorizontally)
            ){
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(120.dp)
                        .align(Center),
                    contentScale = ContentScale.FillWidth
                )

                Image(
                    painter = painterResource(id = R.drawable.edit_profile_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .align(BottomEnd)
                        .clickable { }
                )
            }

            Spacer(modifier = Modifier.height(19.dp))

            Text(text = "Name" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(placeholder = "Salem Ahmed" , enabled = false, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Phone Number" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(placeholder = "+20 102 896 5872" , enabled = false, modifier = Modifier.fillMaxWidth() , trailingIcon = {
                Text(
                    text = "Change",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7A7AF8)
                )
            })

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Email" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(placeholder = "salemahmed@gmail.com" , enabled = false, modifier = Modifier.fillMaxWidth() , trailingIcon = {
                Text(
                    text = "Change",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7A7AF8)
                )
            })

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Country" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(placeholder = "Egypt" , enabled = false, modifier = Modifier.fillMaxWidth() , trailingIcon = {
                Image(painter = painterResource(id = R.drawable.dropdown_arrow), contentDescription = null)
            })

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Gender" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(placeholder = "Male" , enabled = false, modifier = Modifier.fillMaxWidth() , trailingIcon = {
                Image(painter = painterResource(id = R.drawable.dropdown_arrow), contentDescription = null)
            })

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Date of birth" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween
            ){
                PrimaryTextField(
                    placeholder = "1",
                    enabled = false,
                    trailingIcon = {
                        Image(painter = painterResource(id = R.drawable.dropdown_arrow), contentDescription = null)
                    },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(8.dp))

                PrimaryTextField(
                    placeholder = "Sep",
                    enabled = false,
                    trailingIcon = {
                        Image(painter = painterResource(id = R.drawable.dropdown_arrow), contentDescription = null)
                    },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(8.dp))

                PrimaryTextField(
                    placeholder = "2002",
                    enabled = false,
                    trailingIcon = {
                        Image(painter = painterResource(id = R.drawable.dropdown_arrow), contentDescription = null)
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

}

@Composable
@Preview
fun PreviewProfileScreen(){
    ProfileScreen()
}