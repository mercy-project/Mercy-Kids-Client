package com.mercy.kids.component.video

import com.google.android.exoplayer2.SimpleExoPlayer
import javax.inject.Inject

class VideoPlayerImpl @Inject constructor(
    private val exoPlayer: SimpleExoPlayer
): VideoPlayer {

    override fun setVideoUrl(videoUrl: String) {

    }

    override fun play() {



    }

    override fun pause() {


    }

    override fun stop() {


    }
}