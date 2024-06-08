package com.example.pearl.presentation.authentication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.pearl.presentation.authentication.AuthEvent


@Composable
fun OTPTextField(
    modifier: Modifier = Modifier,
    otpSize : Int,
    onFilled : (String) -> Unit
){
    var code by remember {
        mutableStateOf(listOf<Char>())
    }

    val focusRequesters  = remember {
        mutableListOf<FocusRequester>().also{
            focusList ->
            repeat(otpSize){
                focusList.add(FocusRequester())
            }
        }
    }

    Row(
        modifier = modifier.height(50.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        repeat(otpSize){ index ->
            OutlinedTextField(
                value = code.getOrNull(index)?.takeIf {
                            it.isDigit()
                }?.toString() ?: "",
                onValueChange = { value ->
                    if(focusRequesters[index].freeFocus()){
                        val temp = code.toMutableList()

                        if(index < code.size){
                            if(value == ""){
                                temp.removeAt(index)
                                code = temp
                                focusRequesters.getOrNull(index - 1)?.requestFocus()
                            }else{
                                temp[index] = value[index]
                                code = temp
                                focusRequesters.getOrNull(index + 1)?.requestFocus()
                            }
                        }else{
                            temp.add(value.getOrNull(0) ?: ' ')
                            code = temp
                            focusRequesters.getOrNull(index + 1)?.requestFocus() ?: onFilled(
                                code.joinToString("")
                            )
                        }
                    }
                },
                readOnly = false,
                shape = RoundedCornerShape(8.dp) ,
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(50.dp)
                    .focusRequester(focusRequesters[index]),
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = Medium,
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number , imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onDone = null)
            )
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}


@Composable
@Preview(showBackground = true)
fun OTPTextFieldsPreview(){
    OTPTextField(otpSize = 5 , onFilled = {})
}