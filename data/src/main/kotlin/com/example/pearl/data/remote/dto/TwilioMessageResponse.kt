package com.example.pearl.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TwilioMessageResponse(
    @SerializedName("body")
    val body : String,
)
