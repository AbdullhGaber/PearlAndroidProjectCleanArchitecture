package com.example.pearl.presentation.products

import androidx.compose.foundation.Image
import com.example.pearl.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.presentation.common.FeaturedProductCard
import com.example.pearl.presentation.common.HomeButton
import com.example.pearl.presentation.common.RecommendedProductCard
import com.example.pearl.presentation.home.recommendedProducts
import com.example.pearl.presentation.common.SearchBar

@Composable
fun ProductsScreen(){
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ){
        Column(Modifier.padding(ExtraSmallPadding2)){
            Row(
                modifier = Modifier.padding(vertical = ExtraSmallPadding2) , verticalAlignment = Alignment.CenterVertically
            ){
               Image(
                   painter = painterResource(id = R.drawable.arrow_back),
                   contentDescription = null,
                   modifier = Modifier.size(30.dp)
               )
               
               Spacer(modifier = Modifier.width(ExtraSmallPadding))

                SearchBar(text = "Search for product")
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Column(
                modifier = Modifier.align(CenterHorizontally),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.qr_scan), contentDescription = null , modifier = Modifier.size(100.dp))
                Text(
                    text = "Scan the QR of your\nproducts",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            }

            LazyRow(Modifier.fillMaxWidth()){
                items(productTypes.size){
                    Column(Modifier.padding(MediumPadding1)){
                        Icon(
                            painter = painterResource(id = productTypes[it].icon),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                        )

                        Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                        Text(
                            text = productTypes[it].name,
                            fontSize = 7.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Recommended Products" , fontSize = 12.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(recommendedProducts.size){
                    RecommendedProductCard(recommendedProduct = recommendedProducts[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(text = "Featured Products" , fontSize = 12.sp , fontWeight = FontWeight(600))

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Cleanser.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Cleanser }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Moisturizer.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Moisturizer }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Cleanser.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Cleanser }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Moisturizer.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Moisturizer }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Cleanser.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Cleanser }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Moisturizer.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Moisturizer }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Cleanser.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Cleanser }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = ProductType.Moisturizer.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                HomeButton(text = "see more", onClick = { /*TODO*/ })
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            LazyRow(Modifier.fillMaxWidth()){
                items(3){
                    val products = featuredProducts.filter { it.type == ProductType.Moisturizer }
                    FeaturedProductCard(featuredProduct = products[it])
                }
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

        }
    }
}

@Composable
@Preview
fun ProductsScreenPreview(){
    ProductsScreen()
}