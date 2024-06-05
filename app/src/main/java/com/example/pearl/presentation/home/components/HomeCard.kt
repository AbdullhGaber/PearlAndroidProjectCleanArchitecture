package com.example.pearl.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.common.HomeButton
import com.example.pearl.presentation.common.RecommendedProductCard
import com.example.pearl.presentation.home.HomeScreenEvents
import com.example.pearl.presentation.home.HomeScreenState
import com.example.pearl.presentation.home.doctors
import com.example.pearl.presentation.home.recommendedProducts
import com.example.pearl.presentation.home.routineCards
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.pearl_navigator.PearlNavigatorEvents
import com.example.pearl.presentation.products.featuredProducts


@Composable
fun HomeCard(
    navigateToScreen: (String) -> Unit,
    homeScreenState: HomeScreenState,
    homeScreenEvents: (HomeScreenEvents) -> Unit
){
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color.White)
    ){
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(MediumPadding1)
               .verticalScroll(scrollState)
       ){
           Row(Modifier.fillMaxWidth()){
               Box(
                   modifier = Modifier
                       .weight(1f)
                       .clip(RoundedCornerShape(20.dp))
               ){
                   Row(
                       Modifier
                           .fillMaxSize()
                           .padding(MediumPadding1)
                   ){
                        Column(Modifier.weight(1f)){

                            Text(text = "0" , fontWeight = SemiBold , fontSize = 24.sp)
                            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                            Text(text = "Day Streak" , fontWeight = Medium , fontSize = 10.sp)
                            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                            Text(text = "Personal Best: 0" , fontWeight = Normal , fontSize = 6.sp)
                            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                        }

                       Image(
                           painter = painterResource(id = R.drawable.noto_fire),
                           contentDescription = null,
                           modifier = Modifier.size(32.dp)
                       )
                   }
               }

               Spacer(modifier = Modifier.width(MediumPadding1))

               Box(
                   modifier = Modifier
                       .weight(1f)
                       .clip(RoundedCornerShape(20.dp))
               ){
                   Row(
                       Modifier
                           .fillMaxSize()
                           .padding(MediumPadding1)
                   ){
                       Column(Modifier.weight(1f)){

                           Text(text = "0/1" , fontWeight = SemiBold , fontSize = 24.sp)
                           Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                           Text(text = "This Week" , fontWeight = Medium , fontSize = 10.sp)
                           Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                           Text(text = "In Total: 0" , fontWeight = Normal , fontSize = 6.sp)

                       }

                       Image(
                             painter = painterResource(id = R.drawable.noto_fire_ellipse),
                             contentDescription = null,
                             modifier = Modifier.size(35.dp)
                           )
                   }
               }
           }

           Spacer(modifier = Modifier.height(MediumPadding1))
           
           Text(text = "Your Skincare Routine" , fontSize = 12.sp , fontWeight = SemiBold)

           Spacer(modifier = Modifier.height(MediumPadding1))

           Row{
               for(routineCard in routineCards){
                   RoutineCard(
                       routineCard = routineCard , modifier = Modifier
                           .weight(1f)
                           .padding(horizontal = ExtraSmallPadding2)
                           .clickable {
                               navigateToScreen(Route.RoutineNavigation.route)
                           }
                   )
               }
           }

           Spacer(modifier = Modifier.height(MediumPadding1))

           Text(text = "Your Nutrition Routine" , fontSize = 12.sp , fontWeight = SemiBold)

           NutritionRoutineBox(
               modifier = Modifier.clickable{
                   navigateToScreen(Route.NutritionRoutineScreen.route)
               },
               onButtonClick = {
                   navigateToScreen(Route.NutritionRoutineScreen.route)
               }
           )

           Spacer(modifier = Modifier.height(MediumPadding1))

           Text(text = "Your Skin Progress" , fontSize = 12.sp , fontWeight = SemiBold)

           TrackYourSkinBox(
               modifier = Modifier.clickable{
                   navigateToScreen(Route.ProgressScreen.route)
               },
               onButtonClick = {
                   navigateToScreen(Route.ProgressScreen.route)
               }
           )

           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
           ){
               Text(text = "Recommended Products" , fontSize = 12.sp , fontWeight = FontWeight(600))
               HomeButton(
                   text = "see more",
                   onClick = {
                       navigateToScreen(Route.RecommendedProductsScreen.route)
                   }
               )
           }

           Spacer(modifier = Modifier.height(MediumPadding1))

           LazyRow(Modifier.fillMaxWidth()){
               items(featuredProducts.size){
                   RecommendedProductCard(
                       recommendedProduct = recommendedProducts[it] ,
                       onCardClick = {
                           navigateToScreen("${Route.ProductDetailsScreen.route}/${featuredProducts[it].name}")
                       }
                   )
               }
           }

           Spacer(modifier = Modifier.height(MediumPadding1))

           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
           ) {
               Text(text = "Nearest Dermatologists" , fontSize = 12.sp , fontWeight = FontWeight(600))
               HomeButton(text = "see more", onClick = {
                   navigateToScreen(Route.NearestDermatologistsScreen.route)
               })
           }

           LazyRow(Modifier.fillMaxWidth()){
               items(doctors.size){
                   DoctorCard(
                       doctor = doctors[it],
                       onCardClick = {
                           navigateToScreen(Route.DermatologistDetailsScreen.route+"/${doctors[it].name}")
                       }
                   )
               }
           }

           Spacer(modifier = Modifier.height(MediumPadding1))

           RateUsBox()
       }
    }
}

@Composable
@Preview
fun HomeCardPreview(){
//    HomeCard()
}