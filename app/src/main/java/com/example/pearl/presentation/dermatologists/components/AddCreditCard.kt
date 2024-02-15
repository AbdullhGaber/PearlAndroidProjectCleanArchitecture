package com.example.pearl.presentation.dermatologists.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.dermatologists.PaymentMethodData
import com.example.pearl.presentation.dermatologists.paymentMethods

@Composable
fun AddCreditCard(
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

                Image(painter = painterResource(id = R.drawable.credit_card), contentDescription = null )

                Spacer(modifier = Modifier.width(13.dp))

                Text(
                    text = "Add New Card",
                    color = Color(0xFF7F7F7F),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )


        }
    }
}

@Composable
@Preview
fun PreviewAddCreditCard(){
    AddCreditCard()
}