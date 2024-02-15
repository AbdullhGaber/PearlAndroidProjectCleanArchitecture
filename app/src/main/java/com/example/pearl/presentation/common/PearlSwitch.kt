package com.example.pearl.presentation.common

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pearl.Pearl

@Composable
fun PearlSwitch(
    modifier: Modifier = Modifier
){
    val checked = remember {
        mutableStateOf(false)
    }

    Switch(
        checked = checked.value,
        onCheckedChange = { checked.value = it },
        colors = SwitchDefaults.colors(
            checkedTrackColor = Color(0xFF6767F7),
            checkedThumbColor = Color.White,
            uncheckedTrackColor = Color.White,
            uncheckedThumbColor = Color(0xFF6767F7)
        ),
        modifier = modifier,
    )
}

@Composable
@Preview
fun PreviewPearlSwitch(){
    PearlSwitch()
}
