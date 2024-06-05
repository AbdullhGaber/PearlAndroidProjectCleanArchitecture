package com.example.pearl.presentation.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.common.FeaturedProductCard
import com.example.pearl.presentation.common.SearchBar

@Composable
fun AllRecommendedProductCategoryScreen(
    productType: ProductType,
    products : List<FeaturedProduct>,
    navigateToProductDetailsScreen : (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            Modifier
                .padding(ExtraSmallPadding2)
                .fillMaxSize()
        ){
            Row(
                modifier = Modifier.padding(vertical = ExtraSmallPadding2),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(ExtraSmallPadding2)
                        .size(30.dp)
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

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Recommended ${productType.name}",
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            val state = rememberLazyStaggeredGridState()

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier
                    .padding(horizontal = MediumPadding1)
                    .weight(1f),
                state = state,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    items(products.size) {
                       FeaturedProductCard(
                           featuredProduct = products[it],
                           onCardClick = {
                               navigateToProductDetailsScreen(products[it].name)
                           }
                       )
                    }
                }
            )
        }
    }
}

@Composable
@Preview
fun AllRecommendedProductCategoryScreenPreview(){
//    AllRecommendedProductCategoryScreen(ProductType.Cleanser , featuredProducts)
}