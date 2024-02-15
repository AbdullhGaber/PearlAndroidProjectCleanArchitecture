package com.example.pearl.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text : String
){
    var search by remember { mutableStateOf("") }

    OutlinedTextField(
        value = search,
        onValueChange = { search = it },
        label = {
            Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFFADADAD),
            modifier = Modifier.padding(0.dp)
            )},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        leadingIcon = {
                Image(painter = painterResource(id = R.drawable.search_icon), contentDescription = null )
        } ,
        shape = RoundedCornerShape(20.dp),
        keyboardActions = KeyboardActions(onNext = { /* Handle next action */ }),
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    )
}

@Composable
@Preview
fun ProductSearchBarPreview(){
    SearchBar(text = "Search for product")
}