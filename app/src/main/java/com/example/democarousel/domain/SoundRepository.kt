package com.example.democarousel.domain

import com.example.democarousel.presentation.ui.DataItem

interface SoundRepository {

    fun getSounds():List<DataItem>

}