package com.example.pearl.presentation.community.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.pearl.R
import com.example.pearl.presentation.community.PostCardData
import com.example.pearl.presentation.community.posts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCard(
    postData :PostCardData
){
    Card(
        onClick = {},
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column(Modifier.padding(15.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                 Row{
                      Image(
                          painter = painterResource(id = postData.profileImage),
                          contentDescription = null,
                          modifier = Modifier
                              .clip(CircleShape)
                              .size(25.dp),
                          contentScale = ContentScale.FillBounds
                      )

                      Spacer(modifier = Modifier.width(10.dp))

                      Column{
                          Text(
                              text = postData.profileUserName,
                              fontSize = 12.sp,
                              fontWeight = FontWeight(500),
                              color = Color(0xFF1D1B20),
                              letterSpacing = 0.15.sp
                          )

                          Text(
                              text = postData.postTime,
                              fontSize = 8.sp,
                              fontWeight = FontWeight(400),
                              color = Color(0xFF1D1B20),
                              letterSpacing = 0.15.sp
                          )
                      }
                }
                
                Image(
                    painter = painterResource(id = R.drawable.three_dots),
                    contentDescription = null
                )
            }
            
            postData.images?.let {
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                   repeat(postData.images.size){ idx ->
                       Image(
                           painter = painterResource(id = postData.images[idx]),
                           contentDescription = null,
                           modifier = Modifier
                               .clip(RoundedCornerShape(10.dp))
                               .size(150.dp,120.dp),
                           contentScale = ContentScale.FillBounds
                       )

                       Spacer(modifier = Modifier.padding(ExtraSmallPadding))
                   }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = postData.body,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF1D1B20),
                letterSpacing = 0.15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            LikesCommentsRow(postLikes = postData.likesNo, postComments = postData.commentsNo )

        }
    }
}

@Composable
@Preview
fun PreviewPostCard(){
    PostCard(posts[0])
}