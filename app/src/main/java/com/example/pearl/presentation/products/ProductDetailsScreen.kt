package com.example.pearl.presentation.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.common.FeaturedProductCard
import com.example.pearl.presentation.common.HomeButton
import com.example.pearl.presentation.products.components.CollapsingDropdownMenu


@Composable
fun ProductDetailsScreen(
    product: FeaturedProduct,
    navigateToProductDetailsScreen : (String) -> Unit,
    navigateToPrevious : () -> Unit
){
    val state = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(state)
    ){
       Column(
           Modifier
               .fillMaxSize()
               .padding(MediumPadding1),
           horizontalAlignment = CenterHorizontally
       ) {
           Row(Modifier.fillMaxWidth()){
               Box(modifier = Modifier.fillMaxWidth() ){
                   Image(
                       painter = painterResource(id = R.drawable.arrow_back),
                       contentDescription = null,
                       modifier = Modifier
                           .align(TopStart)
                           .clickable {
                               navigateToPrevious()
                           }
                   )

                   Text(
                       text = product.name,
                       fontSize = 18.sp,
                       fontWeight = FontWeight(600),
                       color = Color(0xFF000000),
                       modifier = Modifier
                           .padding(MediumPadding1)
                           .align(TopCenter)
                   )
               }
           }

           Spacer(modifier = Modifier.height(MediumPadding1))

           Image(
               painter = painterResource(id = product.image),
               contentDescription = null,
               modifier = Modifier
                   .padding(MediumPadding1)
                   .align(CenterHorizontally)
           )

           Spacer(modifier = Modifier.height(ExtraSmallPadding))

           Text(
               text = "Cerave Hydrating Cleanser",
               fontSize = 12.sp,
               fontWeight = FontWeight(500),
               color = Color(0xFF000000),
               textAlign = TextAlign.Center,
           )

           Spacer(modifier = Modifier.height(MediumPadding1))

           Row(Modifier.fillMaxWidth()) {
               Image(painter = painterResource(id = R.drawable.good_for_you_product_icon), contentDescription = null )

               Spacer(modifier = Modifier.width(ExtraSmallPadding))

               Column(Modifier.fillMaxWidth()) {
                   Text(
                       text = "Good For Your Skin Type",
                       fontSize = 12.sp,
                       fontWeight = FontWeight(500),
                       color = Color(0xFF000000),
                       textAlign = TextAlign.Center,
                   )

                   Spacer(modifier = Modifier.height(ExtraSmallPadding))

                   Text(
                       text = "It contains 3 ingredients for combinational skin",
                       fontSize = 10.sp,
                       fontWeight = FontWeight(400),
                       color = Color(0xFF7F7F7F),
                   )
               }
           }

           Spacer(modifier = Modifier.height(MediumPadding1))

           CollapsingDropdownMenu(productDropdownMenuData[0])
           CollapsingDropdownMenu(productDropdownMenuData[1])

           Spacer(modifier = Modifier.height(MediumPadding1))

           Text(
               text = "Ingredients",
               fontSize = 18.sp,
               fontWeight = FontWeight(600),
               color = Color(0xFF000000),
           )

           CollapsingDropdownMenu(productDropdownMenuData[2])
           CollapsingDropdownMenu(productDropdownMenuData[3])

           Spacer(modifier = Modifier.height(ExtraSmallPadding2))

           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
           ) {
               Text(text = "Related products" , fontSize = 10.sp , fontWeight = FontWeight(600))
               HomeButton(text = "see more", onClick = { /*TODO*/ })
           }

           Spacer(modifier = Modifier.height(MediumPadding1))

           LazyRow(Modifier.fillMaxWidth()){
               val products = featuredProducts.filter { it.type == ProductType.Moisturizer }
               items(3){
                   FeaturedProductCard(
                       featuredProduct = products[it] ,
                       onCardClick = {
                           navigateToProductDetailsScreen(products[it].name)
                       }
                   )
               }
           }
       }
    }
}

@Preview
@Composable
fun ProductDetailsScreenPreview(){
    ProductDetailsScreen(featuredProducts[1], {} , {})
}