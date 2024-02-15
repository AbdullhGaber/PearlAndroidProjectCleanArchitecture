package com.example.pearl.presentation.notification

import androidx.annotation.DrawableRes
import com.example.pearl.R


data class NotificationCardData(
    val title : String ,
    @DrawableRes val icon : Int,
    val body : String,
    val category : NotificationCategory,
    val time : String
)


val notificationCardDataList = listOf(
    NotificationCardData(
        title = "Appointment Success",
        icon = R.drawable.helal_routine,
        body = "Congratulations - your appointment is confirmed! We’re looking forward to meeting with you.",
        category = NotificationCategory.General,
        time = "1h"
    ),

    NotificationCardData(
        title = "Night Routine",
        icon = R.drawable.helal_routine,
        body = "Congratulations - your appointment is confirmed! We’re looking forward to meeting with you.",
        category = NotificationCategory.General,
        time = "1h"
    ),

    NotificationCardData(
        title = "Dr. Fatma Soliman",
        icon = R.drawable.notification_image1,
        body = "You have a new comment! Dr. Yasmeen Kamal, dermatologist, commented on your community post.",
        category = NotificationCategory.Community,
        time = "47 min"
    ),

    NotificationCardData(
        title = "Soha Salem",
        icon = R.drawable.notification_image2,
        body = "Soha Salem liked your post on skincare essentials.",
        category = NotificationCategory.Community,
        time = "1h"
    ),
)

