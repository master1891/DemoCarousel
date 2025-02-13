package com.example.democarousel.di

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.example.democarousel.presentation.viewmodels.CarouselViewModel

object ProviderViewModels {

    fun provideDataViewModel() =
        CarouselViewModel(
            getDataUseCase = UsecaseProvider.provideGetData ()
        )
}