package com.example.pearl.presentation.favorites

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.R
import com.example.pearl.presentation.common.FeaturedProductCard
import com.example.pearl.presentation.dermatologists.components.DermatologistCard
import com.example.pearl.presentation.dermatologists.favoriteDermatologistsCardData
import com.example.pearl.presentation.dermatologists.nearestDermatologistsCardData
import com.example.pearl.presentation.products.featuredProducts


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoritesScreen(){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(20.dp)){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopStart),
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Favorites",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(Modifier.height(24.dp))

            val tabItems = listOf("Products" , "Dermatologists")
            var selectedIndex by remember{ mutableStateOf(0) }

            TabRow(selectedTabIndex = selectedIndex) {
                tabItems.forEachIndexed{ index: Int, item: String ->
                    Tab(
                        selected = index == selectedIndex,
                        onClick = { selectedIndex = index },
                        text = {
                            Text(
                                text = item,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(700),
                                letterSpacing = 0.36.sp,
                            )
                        },
                        selectedContentColor = Color(0xFF6767F7),
                        unselectedContentColor = Color.Black
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            val pagerState = rememberPagerState(initialPage = 0) { 2 }
            val state = rememberLazyStaggeredGridState()
            HorizontalPager(state = pagerState) {
                when(pagerState.targetPage){
                    0 -> {
                        LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(2),
                            modifier = Modifier
                                .padding(horizontal = Dimens.MediumPadding1)
                                .height(650.dp),
                            state = state,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            content = {
                                items(featuredProducts.filter{it.isFavorite}.size) {
                                    FeaturedProductCard(featuredProduct = featuredProducts.filter{it.isFavorite}[it])
                                }
                            }
                        )
                    }

                    1 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            items(favoriteDermatologistsCardData.size){
                                DermatologistCard(
                                    dermatologistCardData = favoriteDermatologistsCardData[it],
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                    }
                }
            }

            LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress){
                if(!pagerState.isScrollInProgress){
                    selectedIndex = pagerState.currentPage
                }
            }

            LaunchedEffect(key1 = selectedIndex){
                pagerState.animateScrollToPage(selectedIndex)
            }

        }
    }
}

@Composable
@Preview
fun PreviewFavoriteScreen(){
    FavoritesScreen()
}