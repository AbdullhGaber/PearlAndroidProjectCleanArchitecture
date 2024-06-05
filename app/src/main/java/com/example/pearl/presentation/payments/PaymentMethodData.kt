package com.example.pearl.presentation.payments

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class PaymentMethodData(
    val name : String,
    @DrawableRes val icon : Int
)

val paymentMethods = listOf(
    PaymentMethodData(
        name = "Paypal",
        icon = R.drawable.paypal
    ),

    PaymentMethodData(
        name = "Mastercard",
        icon = R.drawable.mastercard
    ),

    PaymentMethodData(
        name = "Visa",
        icon = R.drawable.visa
    ),

    PaymentMethodData(
        name = "Cash Payment",
        icon = R.drawable.money
    )
)