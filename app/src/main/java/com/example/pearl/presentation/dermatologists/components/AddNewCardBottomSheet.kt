package com.example.pearl.presentation.dermatologists.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.PrimaryTextField


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewCardBottomSheet(
    onDismissRequest : () -> Unit,
){
    val modalSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        sheetState = modalSheetState,
        modifier = Modifier
            .height(650.dp)
            .width(416.dp),
        shape = RoundedCornerShape(10.dp),
        containerColor = Color.White
    ) {

        Column(
            modifier = Modifier.padding(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier
                    .align(End)
                    .clickable {
                        onDismissRequest()
                    }
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Add New Card",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
            )

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Name on card",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(10.dp))

            PrimaryTextField(placeholder = "Enter name on card" , modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Card Number",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(6.dp))

            PrimaryTextField(placeholder = "0000 - 0000 - 0000 - 0000" , modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))

            Row(Modifier.fillMaxWidth() , verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)){
                    Text(
                        text = "Expiry date",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF7F7F7F)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    PrimaryTextField(placeholder = "dd/mm")
                }

                Spacer(modifier = Modifier.width(6.dp))

                Column(Modifier.weight(1f)){
                    Text(
                        text = "CVV",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF7F7F7F)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    PrimaryTextField(placeholder = "0000")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            PrimaryButton(text = "Add Card", onClick = { /*TODO*/ } , modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally))
        }

    }
}

@Composable
@Preview
fun PreviewAddNewCardBottomSheet(){
    AddNewCardBottomSheet(onDismissRequest = {})
}