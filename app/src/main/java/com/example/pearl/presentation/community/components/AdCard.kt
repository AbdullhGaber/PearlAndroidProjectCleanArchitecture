package com.example.pearl.presentation.community.components

import com.example.pearl.presentation.community.AdCardData
import com.example.pearl.presentation.community.adPosts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.pearl.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdCard(
    adCardData: AdCardData
){
    Card(
        modifier = Modifier.wrapContentSize(),
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
                        painter = painterResource(id = adCardData.profileImage),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(25.dp),
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column{
                        Text(
                            text = adCardData.profileUserName,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1D1B20),
                            letterSpacing = 0.15.sp
                        )

                        Text(
                            text = "Ad",
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

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            ) {
                Image(
                    painter = painterResource(id = adCardData.image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(color = Color(0xFF6767F7),
                            shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                        .padding(start = 10.dp, top = 2.dp, end = 8.dp, bottom = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Shop Now",
                        fontSize = 11.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.15.sp,
                    )
                        
                        Image(
                            painter = painterResource(id = R.drawable.ad_right_arrow),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }

            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = adCardData.body,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF1D1B20),
                letterSpacing = 0.15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            LikesCommentsRow(postLikes = adCardData.likesNo, postComments = adCardData.commentsNo )

        }
    }
}

@Composable
@Preview
fun PreviewAdCard(){
    AdCard(adPosts[0])
}