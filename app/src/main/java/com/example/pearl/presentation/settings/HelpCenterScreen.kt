package com.example.pearl.presentation.settings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.pearl.R
import com.example.pearl.presentation.notification.NotificationCategory
import com.example.pearl.presentation.notification.components.NotificationCard
import com.example.pearl.presentation.notification.notificationCardDataList
import com.example.pearl.presentation.settings.components.CollapsingDropdownMenu
import com.example.pearl.presentation.settings.components.ContactUsCollapsingDropDownMenu
import com.example.pearl.presentation.settings.components.contactUsCollapsingMenuDataList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HelpCenterScreen(
    navigateToPrevious : () -> Unit
) {
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
                    modifier = Modifier.
                    align(Alignment.TopStart).
                    clickable {
                        navigateToPrevious()
                    },
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Help Center",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
            val tabItems = listOf("FAQ" , "Contact Us")
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

            HorizontalPager(state = pagerState) {
                when(pagerState.targetPage){
                    0 -> {
                        Column{
                            repeat(3){
                                CollapsingDropdownMenu(collapsingMenuData = collapsingMenuDataList[it])
                            }
                        }
                    }

                    1 -> {
                        Column{
                            repeat(5){
                                ContactUsCollapsingDropDownMenu(collapsingMenuData = contactUsCollapsingMenuDataList[it] )
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
fun PreviewHelpCenterScreen(){
    HelpCenterScreen({})
}