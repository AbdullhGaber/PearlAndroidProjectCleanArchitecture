package com.example.pearl.presentation.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.pearl.R
import com.example.pearl.presentation.common.FeaturedProductCard
import com.example.pearl.presentation.common.SearchBar

@Composable
fun ProductCategoryScreen(
    productType: ProductType,
    products : List<FeaturedProduct>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(Modifier.padding(Dimens.ExtraSmallPadding2).fillMaxSize()) {
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
                text = productType.name,
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            LazyRow(Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding1) , verticalAlignment = Alignment.CenterVertically){
                items(productFilters.size){
                    Column(Modifier.padding(MediumPadding1), horizontalAlignment = Alignment.CenterHorizontally) {
                        val productFilter = productFilters[it]
                        Image(
                            painter = painterResource(id = productFilter.icon),
                            contentDescription = null,
                            modifier = Modifier.size(productFilter.size)
                        )

                        Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                        Text(
                            text = productFilter.name,
                            fontSize = 10.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7F7F7F),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(ExtraSmallPadding2))

            val state = rememberLazyStaggeredGridState()

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = MediumPadding1).height(500.dp),
                state = state,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    items(products.size) {
                       FeaturedProductCard(featuredProduct = products[it])
                    }
                }
            )
        }
    }
}

@Composable
@Preview
fun ProductCategoryScreenPreview(){
    ProductCategoryScreen(ProductType.Cleanser , featuredProducts)
}