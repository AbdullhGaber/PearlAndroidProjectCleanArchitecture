package com.example.pearl.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.HorizontalLine
import com.example.pearl.presentation.common.getDrawerNavigationScreenRouteByIndex
import com.example.pearl.presentation.home.components.HomeCard
import com.example.pearl.presentation.home.components.HomeTopSection
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.pearl_navigator.PearlNavState
import com.example.pearl.presentation.pearl_navigator.PearlNavigatorEvents
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navigateToScreen: (String) -> Unit,
    homeScreenState: HomeScreenState,
    homeScreenEvents: (HomeScreenEvents) -> Unit
){
  Box(modifier = Modifier.fillMaxSize()){
      Image(
          painter = painterResource(id = R.drawable.bg_home),
          contentDescription = null,
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.FillBounds
      )
      Column{
          HomeTopSection()
          HomeCard(
              navigateToScreen,
              homeScreenState,
              homeScreenEvents
          )
      }
  }
}

@Composable
@Preview
fun HomeScreenPreview(){
//    HomeScreen()
}