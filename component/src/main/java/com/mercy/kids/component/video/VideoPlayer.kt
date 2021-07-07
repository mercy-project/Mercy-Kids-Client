package com.mercy.kids.component.video

interface VideoPlayer {

    fun setVideoUrl(videoUrl: String)

    fun play()

    fun pause()

    fun stop()

}