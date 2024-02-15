package com.example.pearl.presentation.notification

sealed class NotificationCategory(val category: String){
    object General : NotificationCategory("General")
    object Community : NotificationCategory("Community")
}
