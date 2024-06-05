package com.example.pearl.presentation.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.example.newsapp.presentation.Dimens
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.presentation.common.FeaturedProductCard
import com.example.pearl.presentation.common.HomeButton
import com.example.pearl.presentation.common.SearchBar

@Composable
fun RecommendedProductsScreen(
    navigateToPreviousTab: () -> Unit,
    navigateToProductDetailsScreen : (String) -> Unit,
    onProductTypeButtonClick : (ProductType) -> Unit
){
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ){
        Column(Modifier.padding(ExtraSmallPadding2)){
            Row(
                modifier = Modifier.padding(vertical = Dimens.ExtraSmallPadding2),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(ExtraSmallPadding2)
                        .size(30.dp)
                        .clickable {
                            navigateToPreviousTab()
                        }
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                SearchBar(Modifier.weight(1f), "Search for product")

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Image(
                    painter = painterResource(id = R.drawable.qr_scan_product),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(ExtraSmallPadding2)
                        .size(30.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.align(CenterHorizontally),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Recommended Products",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            }

            LazyRow(Modifier.fillMaxWidth()){
                items(productTypes.size){
                    Column(
                        Modifier
                            .padding(MediumPadding1)
                            .clickable {
                                onProductTypeButtonClick(productTypes[it])
                            }
                    ){
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

            productTypes.forEach{ productType ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(text = productType.name , fontSize = 10.sp , fontWeight = FontWeight(600))
                    HomeButton(
                        text = "see more",
                        onClick = {
                            onProductTypeButtonClick(productType)
                        }
                    )
                }

                Spacer(modifier = Modifier.height(MediumPadding1))

                LazyRow(Modifier.fillMaxWidth()){
                    val products = featuredProducts.filter { it.type == productType}
                    items(3){
                        if(products.size >= 3)
                           FeaturedProductCard(
                               featuredProduct = products[it],
                               onCardClick = {
                                   navigateToProductDetailsScreen(products[it].name)
                               }
                           )
                    }
                }
                Spacer(modifier = Modifier.height(MediumPadding1))
            }
        }
    }
}

@Composable
@Preview
fun RecommendedProductsScreenPreview(){
    RecommendedProductsScreen({},{},{})
}