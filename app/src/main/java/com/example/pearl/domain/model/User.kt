package com.example.pearl.domain.model

data class User(
    val firstName : String = "",
    val lastName : String = "",
    val email : String = "",
    val phoneNo : String = "",
    val gender: UserGender = UserGender.MALE,
    val birthdate : String = "",
    val address: UserAddress = UserAddress()
)
