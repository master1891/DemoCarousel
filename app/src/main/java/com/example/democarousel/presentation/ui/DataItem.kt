package com.example.democarousel.presentation.ui

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class DataItem(
    val id:Long = System.currentTimeMillis(),
    @DrawableRes val resource:Int,
    @RawRes val sound:Int,
    val title:String = "",
)
