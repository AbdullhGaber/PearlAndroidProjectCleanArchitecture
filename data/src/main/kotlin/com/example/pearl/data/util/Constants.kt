package com.example.pearl.data.util

import com.example.pearl.data.BuildConfig

object Constants {
    const val USER_REFERENCE: String = "users"
    const val DOCTOR_REFERENCE: String = "doctors"
    const val USER_SETTINGS = "user_settings"
    const val APP_ENTRY = "app_entry"
    val TWILIO_BASE_URL = BuildConfig.TWILIO_BASE_URL
    val TWILIO_SERVICE_SID = BuildConfig.TWILIO_SERVICE_SID
    val TWILIO_ACCOUNT_SID = BuildConfig.TWILIO_ACCOUNT_SID
    val TWILIO_AUTH_TOKEN = BuildConfig.TWILIO_AUTH_TOKEN

    val TEST_TWILIO_ACCOUNT_SID = BuildConfig.TEST_TWILIO_ACCOUNT_SID
    val TEST_TWILIO_AUTH_TOKEN = BuildConfig.TEST_TWILIO_AUTH_TOKEN
}
