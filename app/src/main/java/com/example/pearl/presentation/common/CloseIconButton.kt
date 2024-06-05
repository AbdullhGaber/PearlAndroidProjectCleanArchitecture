package com.example.pearl.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.newsapp.presentation.Dimens
import com.example.pearl.R

@Composable
fun CloseIconButton(
    modifier: Modifier = Modifier,
    onClick : () -> Unit = {}
){
    Icon(
        painter = painterResource(id = R.drawable.ic_close),
        contentDescription = null,
        modifier = modifier.
        padding(start = Dimens.MediumPadding1).
        clickable {
            onClick()
        }
    )
}