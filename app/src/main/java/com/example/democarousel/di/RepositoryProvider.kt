package com.example.democarousel.di

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.example.democarousel.data.SoundRepositoryImpl
import com.example.democarousel.domain.SoundRepository
import com.example.democarousel.presentation.viewmodels.CarouselViewModel

object RepositoryProvider {

    fun providesCarouselRepository() = SoundRepositoryImpl()
}
