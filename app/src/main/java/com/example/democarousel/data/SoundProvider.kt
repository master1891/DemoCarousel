package com.example.democarousel.data

import com.example.democarousel.R
import com.example.democarousel.presentation.ui.DataItem

object SoundProvider {

    // TODO: Ajustar el provider
    //Usar diferentes recursos :)

    fun getData() :List<DataItem> {
        val listPlaceHolder = mutableListOf<DataItem>()

        listPlaceHolder.apply {
            add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound = R.raw.beep))
            add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound = R.raw.beep))
            add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound = R.raw.beep))
            add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound = R.raw.beep))
        }

        return  listPlaceHolder
    }

}