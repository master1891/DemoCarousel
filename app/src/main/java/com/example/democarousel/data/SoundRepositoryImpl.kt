package com.example.democarousel.data

import com.example.democarousel.domain.SoundRepository
import com.example.democarousel.presentation.ui.DataItem

class SoundRepositoryImpl():SoundRepository {

    override fun getSounds(): List<DataItem> {
        return SoundProvider.getData()
    }

}