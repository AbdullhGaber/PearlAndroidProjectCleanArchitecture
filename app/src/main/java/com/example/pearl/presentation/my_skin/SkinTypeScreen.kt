package com.example.pearl.presentation.my_skin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun MyTypeScreen(){
    Box(
        modifier = Modifier
            .background(Color(0xFFFAF6FF))
            .fillMaxSize()
            .padding(20.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopStart),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Skin Type",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier.padding(20.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Your Skin Type",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            
            Spacer(modifier = Modifier.height(11.dp))


            Text(
                text = "Combination",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(25.dp))

            Image(painter = painterResource(id = R.drawable.skin_type_girl), contentDescription = null )

            Box(
                Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
            ){
                Column(Modifier.padding(vertical = 20.dp , horizontal = 25.dp)){
                    Text(
                        text = "About your skin type:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Your skin profile indicates a combination skin type, This means your skin may have a mix of oily and dry areas. This balance calls for a versatile skincare approach to cater to the distinct needs of each area.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
        
        PrimaryButton(
            text = "Take a Selfie",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
@Preview
fun PreviewMyTypeScreen(){
    MyTypeScreen()
}