package com.example.pearl.presentation.payments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.payments.components.AddCreditCard
import com.example.pearl.presentation.payments.components.AddNewCardBottomSheet
import com.example.pearl.presentation.payments.components.OnlinePaymentMethod

@Composable
fun PaymentMethodScreen(
    navigateToScreen : () -> Unit,
    navigateToPrevious : () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Box(
                Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.
                    align(Alignment.TopStart).
                    clickable {
                        navigateToPrevious()
                    }
                )
                
                Text(
                    text = "Payment Method",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(19.dp))

            Image(
                painter = painterResource(id = R.drawable.step_1),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Credit and Debit Card",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(15.dp))

            val isSheetOpen = remember {
                mutableStateOf(false)
            }

            if(isSheetOpen.value){
                AddNewCardBottomSheet {
                    isSheetOpen.value = false
                }
            }

            AddCreditCard(modifier = Modifier.clickable {
                isSheetOpen.value = true
            })

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "More Payment Options",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(15.dp))
            
            Column{
                repeat(3){
                    OnlinePaymentMethod(paymentMethodData = paymentMethods[it] , modifier = Modifier.padding(bottom = 19.dp))
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Cash Payment",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(18.dp))


            OnlinePaymentMethod(paymentMethodData = paymentMethods.last())


        }

        PrimaryButton(
            text = "Next",
            onClick = {
                  navigateToScreen()
            },
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewPaymentMethodScreen(){
    PaymentMethodScreen({},{})
}