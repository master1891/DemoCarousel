package com.example.democarousel.util

import androidx.annotation.RawRes

/**
 * Se crea interfaz para manejo de diferentes implementaciones
 */
interface SoundInterface {
    /**
     * @param resourceSound raw necesario para la implementacion
     */
    fun play(@RawRes resourceSound:Int)
    fun release()
}
