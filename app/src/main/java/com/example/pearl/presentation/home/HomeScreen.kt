package com.example.pearl.presentation.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.HorizontalLine
import com.example.pearl.presentation.home.components.HomeCard
import com.example.pearl.presentation.home.components.HomeTopSection
import com.example.pearl.presentation.products.ProductDropdownMenuData
import com.example.pearl.presentation.products.components.CollapsingDropdownMenu
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(){
  Box(modifier = Modifier.fillMaxSize()){


      var selectedIndex by rememberSaveable{
          mutableStateOf(0)
      }

      val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

      val coroutineScope = rememberCoroutineScope()

      ModalNavigationDrawer(
          drawerContent = {
              ModalDrawerSheet{
                  Spacer(modifier = Modifier.height(30.dp))
                  Row(
                      verticalAlignment = Alignment.CenterVertically,
                      modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                  ){
                      Image(
                          painter = painterResource(id = R.drawable.profile_image),
                          contentDescription = null,
                          modifier = Modifier
                              .clip(CircleShape)
                              .size(40.dp),
                          contentScale = ContentScale.FillBounds
                      )

                      Spacer(Modifier.width(12.dp))

                      Column{

                          Text("Salem Ahmed" , fontSize = 14.sp , fontWeight = SemiBold)

                          Spacer(Modifier.height(10.dp))

                          Row(verticalAlignment = Alignment.CenterVertically){

                              Image(
                                  painter = painterResource(id = R.drawable.profile_edit_sidebar),
                                  contentDescription = null,
                                  modifier = Modifier.size(10.dp),
                                  contentScale = ContentScale.FillBounds
                              )

                              Spacer(modifier = Modifier.width(4.dp))

                              Text(
                                  "Edit Profile",
                                  fontSize = 8.sp,
                                  fontWeight = Normal,
                                  color = Color(0xFF7E7E7E)
                              )
                          }
                      }
                  }

                  Spacer(Modifier.height(55.dp))

                  sideMenuItems.forEachIndexed{
                      index, sideMenuItem ->
                      NavigationDrawerItem(
                          label = {
                                  Text(
                                      text = sideMenuItem.name,
                                      fontSize = 14.sp,
                                      fontWeight = SemiBold,
                                      color = if(selectedIndex == index) Color(0xFF6767F7) else Color(0xFF000000)
                                  )
                          },
                          selected = selectedIndex == index,
                          onClick = {
                              selectedIndex = index
                              coroutineScope.launch {
                                  drawerState.close()
                              }
                          },
                          icon = {
                              val selected = selectedIndex == index

                              if(!selected){
                                  Image(
                                      painter = painterResource(id = sideMenuItem.unSelectedIcon ),
                                      contentDescription = null
                                  )
                              }

                              if(selected && sideMenuItem.selectedIcon != null){
                                  Image(
                                      painter = painterResource(id = sideMenuItem.selectedIcon ),
                                      contentDescription = null
                                  )
                              }

                          },
                          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                      )
                      if(index == 1 ){
                          Spacer(Modifier.height(44.dp))
                          HorizontalLine()
                      }
                  }
              }
          },
          drawerState = drawerState,
          gesturesEnabled = drawerState.isOpen
      ) {
          Scaffold(
              topBar = {
                  Row(horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier
                      .fillMaxWidth()
                      .padding(20.dp)){
                      Image(
                          painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                          contentDescription = null,
                          modifier = Modifier.clickable{
                              coroutineScope.launch {
                                  drawerState.open()
                              }
                          }
                      )

                      Image(
                          painter = painterResource(id = R.drawable.ic_baseline_notifications_none_24),
                          contentDescription = null
                      )
                  }
              }
          ) {
              Image(
                  painter = painterResource(id = R.drawable.bg_home),
                  contentDescription = null,
                  modifier = Modifier.fillMaxSize(),
                  contentScale = ContentScale.FillBounds
              )

              Column{
                  HomeTopSection()
                  HomeCard()
              }
          }
      }
  }
}

@Composable
@Preview
fun HomeScreenPreview(){
    HomeScreen()
}