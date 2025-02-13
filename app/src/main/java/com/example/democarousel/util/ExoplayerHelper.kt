package com.example.democarousel.util

import android.content.Context
import androidx.annotation.RawRes
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.democarousel.R


class ExoplayerHelper(val context: Context):SoundInterface{

     val exoPlayer: ExoPlayer by lazy {
         ExoPlayer.Builder(context).build()
     }

    override fun play( @RawRes resourceSound: Int) {

        val resource = context.getString(R.string.soundPathTemplate,context.packageName,resourceSound.toString())
        val mediaItem:MediaItem = MediaItem.fromUri(resource)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()
     }

    override fun release() {
        //exoPlayer.release()
    }

}
