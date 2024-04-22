package com.example.pearl.presentation.my_appointments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.pearl.presentation.my_appointments.components.CompletedScheduleCard
import com.example.pearl.presentation.common.SearchBar
import com.example.pearl.presentation.dermatologists.MyAppointmentScreen
import com.example.pearl.presentation.dermatologists.components.DermatologistScheduleCard
import com.example.pearl.presentation.dermatologists.dermatologistsSchedule
import com.example.pearl.presentation.my_appointments.components.CancelledScheduleCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyAppointmentsScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)){
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopStart),
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "My Appointments",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )

                Image(
                    painter = painterResource(id = R.drawable.chat_dots),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp),
                    contentScale = ContentScale.FillBounds
                )
            }


            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Location",
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row{
                Image(
                    painter = painterResource(id = R.drawable.dermatologist_location),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )

                Spacer(modifier = Modifier.width(3.dp))

                Text(
                    text = "El Mansoura, Egypt",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                )

                Spacer(modifier = Modifier.width(3.dp))
            }

            Spacer(modifier = Modifier.height(15.dp))

            SearchBar(text = "Search for dermatologist")

            Spacer(Modifier.height(16.dp))

            val tabItems = listOf("Upcoming" , "Completed" , "Cancelled")
            var selectedIndex by remember{ mutableIntStateOf(0) }

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

            val pagerState = rememberPagerState(initialPage = 0) { 3 }

            HorizontalPager(state = pagerState) {
                when(pagerState.targetPage){
                    0 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            items(dermatologistsSchedule.size){
                                DermatologistScheduleCard(
                                    dermatologistScheduleCardData = dermatologistsSchedule[it],
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                    }

                    1 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            items(dermatologistsSchedule.size){
                                CompletedScheduleCard(
                                    dermatologistScheduleCardData = dermatologistsSchedule[it],
                                    modifier = Modifier.padding(5.dp),
                                )
                            }
                        }
                    }

                    2 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            items(dermatologistsSchedule.size){
                                CancelledScheduleCard(
                                    dermatologistScheduleCardData = dermatologistsSchedule[it],
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
fun PreviewMyAppointmentsScreen(){
    MyAppointmentsScreen()
}