package com.example.pearl.presentation.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.community.components.AdCard
import com.example.pearl.presentation.community.components.PostCard
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.pearl_navigator.PearlNavEventFunction

@Composable
fun CommunityScreen(
    navigateToTab : (String) -> Unit
){
    val state = rememberScrollState()

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(state)
    ){
       Column(Modifier
           .fillMaxSize()
           .padding(25.dp)) {
           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ) {
               Spacer(modifier = Modifier.size(24.dp))

               Row(verticalAlignment = Alignment.CenterVertically){
                   Image(
                       painter = painterResource(id = R.drawable.chat_dots),
                       contentDescription = null,
                       modifier = Modifier.size(24.dp),
                       contentScale = ContentScale.FillBounds
                   )

                   Spacer(modifier = Modifier.width(5.dp))

                   Image(
                       painter = painterResource(id = R.drawable.ic_baseline_notifications_none_24),
                       contentDescription = null,
                       modifier = Modifier.clickable {
                           navigateToTab(Route.NotificationScreen.route)
                       }
                   )
               }
           }

           Spacer(modifier = Modifier.height(16.dp))

           Row(verticalAlignment = Alignment.CenterVertically){
               Image(
                   painter = painterResource(id = R.drawable.profile_image),
                   modifier = Modifier
                       .clip(CircleShape)
                       .size(30.dp),
                   contentDescription = null,
                   contentScale = ContentScale.Crop
               )

               Spacer(modifier = Modifier.width(7.dp))

               Text(
                   text = "What’s in your mind?",
                   fontSize = 10.sp,
                   lineHeight = 19.6.sp,
                   fontWeight = FontWeight(500),
                   color = Color(0xFF7F7F7F),
                   letterSpacing = 0.1.sp,
               )
           }

           Spacer(modifier = Modifier.height(10.dp))

           PostCard(postData = posts[0])

           Spacer(modifier = Modifier.height(10.dp))

           PostCard(postData = posts[1])

           Spacer(modifier = Modifier.height(10.dp))

           AdCard(adCardData = adPosts[0])

           Spacer(modifier = Modifier.height(10.dp))

           PostCard(postData = posts[2])

       }
    }
}

@Composable
@Preview
fun PreviewCommunityScreen(){
//    CommunityScreen()
}