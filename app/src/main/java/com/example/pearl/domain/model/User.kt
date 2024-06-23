package com.example.pearl.domain.model

data class User(
    val uid : String = "",
    val name : String = "",
    val email : String = "",
    val phoneNo : String = "",
    val gender: UserGender = UserGender.MALE,
    val age : String = "",
    val routines : List<Any> = emptyList(),
    val appointments : List<Any> = emptyList(),
    val questionAnswers : HashMap<String,String>? = null,
    val address : UserAddress = UserAddress(),
)
