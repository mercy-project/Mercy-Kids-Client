package com.mercy.kids.component.video

import android.content.Context
import com.google.android.exoplayer2.SimpleExoPlayer
import javax.inject.Inject

class VideoPlayerImpl @Inject constructor(applicationContext: Context): VideoPlayer {

    private val exoPlayer = SimpleExoPlayer.Builder(applicationContext).build()

    override fun setVideoUrl(videoUrl: String) {

    }

    override fun play() {

    }

    override fun pause() {


    }

    override fun stop() {


    }
}