package com.example.pearl.presentation.my_skin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavController
import com.example.pearl.R
import com.example.pearl.presentation.my_skin.components.MySkinBox
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.pearl_navigator.PearlNavEventFunction
import com.example.pearl.presentation.pearl_navigator.PearlNavigatorEvents

@Composable
fun MySkinScreen(
     navigateToPreviousTab : () -> Unit
){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        Column(modifier = Modifier.padding(20.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .clickable {
                           navigateToPreviousTab()
                        },
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "My Skin",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
            
            Spacer(modifier = Modifier.height(56.dp))

            val skinBoxList = listOf("Skin type" , "Skin concerns" , "Food allergies" , "Skin quiz")
            
            repeat(4){
                MySkinBox(text = skinBoxList[it])
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewMySkinScreen(){
//    MySkinScreen()
}