package com.example.pearl.domain.model

data class UserAddress(
    val userId : Int = -1,
    val street : String = "",
    val country : String = "",
    val state : String = ""
)
