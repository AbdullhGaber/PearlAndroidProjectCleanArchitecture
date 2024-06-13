package com.example.pearl.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.onboarding.components.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onBoardingEvent: (OnBoardingEvent) -> Unit,
    navigateToAuthScreen: () -> Unit
){
    val lightBackground = R.drawable.bg_on_boarding_1_2
    val nightBackground = R.drawable.bg_on_boarding_3

    val pageState = rememberPagerState(initialPage = 0) {
        pages.size
    }

   //background
   Box(modifier = Modifier.fillMaxSize()){
       Image(
           painter = painterResource(
           id = if(pageState.currentPage == 2) nightBackground else lightBackground,

       ),
           modifier = Modifier.matchParentSize(),
           contentScale = ContentScale.FillBounds,
           contentDescription = null
       )
   }

   Column( horizontalAlignment = Alignment.CenterHorizontally) {

      HorizontalPager(state = pageState) {
          OnBoardingPage(page = pages[pageState.currentPage])
      }

      Spacer(modifier = Modifier.weight(1f))

      PageIndicator(selectedPageIdx = pageState.currentPage)

      Spacer(modifier = Modifier.weight(1f))

      Row(
          modifier = Modifier
              .padding(horizontal = 20.dp)
              .fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
      ){
          val scope = rememberCoroutineScope()
          when(pageState.currentPage){
              0 -> {
                  Spacer(modifier = Modifier.width(56.dp))

                  OnBoardingForwardButton(onClick = {
                      scope.launch {
                          pageState.animateScrollToPage(page = pageState.currentPage + 1)
                      }
                  })

              }

              2 -> {
                  OnBoardingBackwardButton(onClick = {
                      scope.launch {
                          pageState.animateScrollToPage(page = pageState.currentPage - 1)
                      }
                  })

                  LastOnBoardingPageButton(onClick = {
                      scope.launch {
                          navigateToAuthScreen()
                          onBoardingEvent(OnBoardingEvent.SaveAppEntry)
                      }
                  })
              }

              else -> {
                  OnBoardingBackwardButton(onClick = {
                      scope.launch {
                          pageState.animateScrollToPage(page = pageState.currentPage - 1)
                      }
                  })

                  OnBoardingForwardButton(
                      onClick = {
                          scope.launch {
                              pageState.animateScrollToPage(page = pageState.currentPage + 1)
                          }
                      }
                  )
              }
          }
      }


   }
}

@Composable
@Preview
fun OnBoardingScreenPreview(){
    OnBoardingScreen({} , {})
}