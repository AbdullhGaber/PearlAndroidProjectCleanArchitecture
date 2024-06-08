package com.example.pearl.domain.model

data class User(
    val uid : String = "",
    val firstName : String = "",
    val lastName : String = "",
    val email : String = "",
    val phoneNo : String = "",
    val gender: UserGender = UserGender.MALE,
    val age : String = "",
    val routines : List<Any> = emptyList(),
    val appointments : List<Any> = emptyList(),
    val address : UserAddress,
)
