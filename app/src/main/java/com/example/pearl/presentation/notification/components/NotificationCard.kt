package com.example.pearl.presentation.notification.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.presentation.common.HorizontalLine
import com.example.pearl.presentation.notification.NotificationCardData
import com.example.pearl.presentation.notification.notificationCardDataList

@Composable
fun NotificationCard(
    notificationCardData: NotificationCardData,
    modifier : Modifier = Modifier
){
    Box(
        modifier.background(Color(0xFFFAF8FF))
    ){
        Text(
            text = notificationCardData.time,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF7F7F7F),
            modifier = Modifier
                .align(TopEnd)
                .padding(10.dp)
        )

        Column{
            Row(modifier = Modifier.padding(20.dp)){
                Image(
                    painter = painterResource(id = notificationCardData.icon),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(60.dp)
                )

                Spacer(modifier = Modifier.width(9.dp))

                Column{
                    Text(notificationCardData.title, fontSize = 16.sp , fontWeight = FontWeight.Medium)

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(notificationCardData.body , fontSize = 12.sp , fontWeight = FontWeight.Normal)
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            HorizontalLine()
        }
    }

}

@Composable
@Preview
fun PreviewNotificationCard(){
    NotificationCard(notificationCardDataList[0])
}