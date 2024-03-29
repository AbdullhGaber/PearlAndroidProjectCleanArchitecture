package com.example.pearl.presentation.authentication.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

val textList = listOf(
    mutableStateOf(
        TextFieldValue(
            text = "",
            selection = TextRange(0)
        )
    ),

    mutableStateOf(
        TextFieldValue(
            text = "",
            selection = TextRange(0)
        )
    ),

    mutableStateOf(
        TextFieldValue(
            text = "",
            selection = TextRange(0)
        )
    ),

    mutableStateOf(
        TextFieldValue(
            text = "",
            selection = TextRange(0)
        )
    ),

    mutableStateOf(
        TextFieldValue(
            text = "",
            selection = TextRange(0)
        )
    ),
)

val requesterList = listOf(
    FocusRequester(),
    FocusRequester(),
    FocusRequester(),
    FocusRequester(),
    FocusRequester()
)

@Composable
fun InputView(
    value: TextFieldValue,
    onValueChange : (TextFieldValue) -> Unit,
    focusRequester : FocusRequester
){
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        readOnly = false,
        modifier = Modifier
            .padding(3.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Transparent)
            .wrapContentSize()
            .focusRequester(focusRequester),
        maxLines = 1,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .size(52.dp, 58.dp)
                    .border(2.dp, Color.Gray),
                contentAlignment = Alignment.Center
            ){
                innerTextField()
            }
        },
        cursorBrush = SolidColor(Color.White),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = Medium,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number , imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = null)
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ContentView(
    textList : List<MutableState<TextFieldValue>>,
    requesterList: List<FocusRequester>
){
    val focusManger = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current


        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 20.dp)
                    .align(Alignment.TopCenter)
            ){
                for(i in textList.indices){
                    InputView(
                        value = textList[i].value,
                        onValueChange = { newValue ->
                            //user is removing/replacing number from the text field
                            if(textList[i].value.text.isNotEmpty()){
                                if(newValue.text.isEmpty()){
                                    textList[i].value = TextFieldValue(
                                        text = "",
                                        selection = TextRange(0)
                                    )
                                }
                                return@InputView
                            }
                            //user is adding a new value to the text field
                            textList[i].value = TextFieldValue(
                                text = newValue.text,
                                selection = TextRange(newValue.text.length)
                            )

                            connectInputCode(textList){
                                focusManger.clearFocus()
                                keyboardController?.hide()

                                if(it){
                                    Toast.makeText(context, "code success", Toast.LENGTH_SHORT).show()
                                }else{
                                    Toast.makeText(context, "code fail", Toast.LENGTH_SHORT).show()
                                    for(text in textList){
                                        text.value = TextFieldValue(
                                            text = "",
                                            selection = TextRange(0)
                                        )
                                    }
                                }
                            }
                            nextFocus(textList = textList, requesterList = requesterList)

                        },
                        focusRequester = requesterList[i]
                    )
                }
            }
        }

    LaunchedEffect(key1 = null , block = {
        delay(300)
        requesterList[0].requestFocus()
    })
}

fun nextFocus(
    textList : List<MutableState<TextFieldValue>>,
    requesterList: List<FocusRequester>
){
    for(i in textList.indices){
        if(textList[i].value.text.isEmpty()){
            if(i < textList.size){
                requesterList[i].requestFocus()
                break
            }
        }
    }
}


fun connectInputCode(
    textList: List<MutableState<TextFieldValue>>,
    onSuccess: ((Boolean) -> Unit)?
){
    var code = ""

    for(text in textList){
        code += text.value.text
    }

    if(code.length == 5 ){
        verifyCode(
            code,
            onSuccess = {
                onSuccess?.let { it(true) }
            },
            onFailure = {
              onSuccess?.let { it(false) }
            },
        )
    }
}

fun verifyCode(code : String , onSuccess : () -> Unit , onFailure : () -> Unit){
    if(code == "44135"){
        onSuccess()
    }else{
        onFailure()
    }
}

@Composable
fun OTPTextFields(){
    ContentView(textList , requesterList)
}

@Composable
@Preview
fun OTPTextFieldsPreview(){
    OTPTextFields()
}