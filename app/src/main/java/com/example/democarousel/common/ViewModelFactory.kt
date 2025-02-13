package com.example.democarousel.common

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.democarousel.di.ProviderViewModels
import com.example.democarousel.presentation.viewmodels.CarouselViewModel


class ViewModelFactory (
    private val moduleViewModel:ModuleViewModel,
    private val savedStateRegistryOwner: SavedStateRegistryOwner,
    private val bundle: Bundle? = null,
    private val context: Context
): AbstractSavedStateViewModelFactory(savedStateRegistryOwner,bundle) {


    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
            if(!modelClass.isAssignableFrom(moduleViewModel.clazz)) throw Exception("Unknown ViewModel class")
            val appContext = context.applicationContext

            return when(moduleViewModel) {
                ModuleViewModel.CAROUSEL_VIEW_MODEL -> ProviderViewModels.provideDataViewModel()

                else -> throw Exception("Unknown ViewModel class")
            } as T
    }
}

enum class ModuleViewModel(val clazz: Class<*>) {
    CAROUSEL_VIEW_MODEL(CarouselViewModel::class.java),

}