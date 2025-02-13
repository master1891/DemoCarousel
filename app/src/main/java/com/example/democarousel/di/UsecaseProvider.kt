package com.example.democarousel.di

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.example.democarousel.domain.GetDataUseCase
import com.example.democarousel.presentation.viewmodels.CarouselViewModel

object UsecaseProvider {

    fun provideGetData() =
        GetDataUseCase(RepositoryProvider.providesCarouselRepository())
}