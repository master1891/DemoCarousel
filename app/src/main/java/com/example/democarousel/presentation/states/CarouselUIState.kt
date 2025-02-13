package com.example.democarousel.presentation.states

import com.example.democarousel.presentation.ui.DataItem

sealed class CarouselUIState {
    data object Init:CarouselUIState()
    data class Success(val list: List<DataItem>):CarouselUIState()
    data object Error:CarouselUIState()
}