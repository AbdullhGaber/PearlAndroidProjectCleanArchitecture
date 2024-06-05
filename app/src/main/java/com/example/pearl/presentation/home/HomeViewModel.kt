package com.example.pearl.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.positionChange
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val mHomeScreenState = mutableStateOf(HomeScreenState())
    fun onEvent(event : HomeScreenEvents){
        when(event){
            is HomeScreenEvents.NavigateToScreen -> {

            }
        }
    }
}