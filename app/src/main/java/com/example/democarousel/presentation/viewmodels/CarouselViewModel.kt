package com.example.democarousel.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.democarousel.domain.GetDataUseCase
import com.example.democarousel.presentation.states.CarouselUIState
import kotlinx.coroutines.flow.MutableStateFlow

class CarouselViewModel(
    val getDataUseCase: GetDataUseCase
):ViewModel() {

    var _stateCarousel:MutableStateFlow<CarouselUIState> = MutableStateFlow(CarouselUIState.Init)
    val carouselState = _stateCarousel

    fun requestData(){
        try {
            val response = getDataUseCase.invoke()
            if (response.isNotEmpty())
                _stateCarousel.value = CarouselUIState.Success(response)
            else
                _stateCarousel.value = CarouselUIState.Success(emptyList())

        }catch (ex:Exception){
            _stateCarousel.value = CarouselUIState.Success(emptyList())
        }

    }

}