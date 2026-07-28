package com.example.pearl.data.remote

import com.example.pearl.data.remote.dto.TwilioMessageResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface TwilioApiService {
    @FormUrlEncoded
    @POST("/2010-04-01/Accounts/{accountSid}/Messages.json")
    fun sendOTP(
        @Path("accountSid") accountSid: String,
        @Field("To") to: String,
        @Field("From") from: String,
        @Field("Body") body: String,
    ): Call<TwilioMessageResponse>
}
