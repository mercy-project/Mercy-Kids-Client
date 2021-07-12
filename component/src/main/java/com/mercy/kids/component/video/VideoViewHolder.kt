package com.mercy.kids.component.video

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSourceFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.mercy.kids.base.component.DataBindingViewHolder
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

abstract class VideoViewHolder<B: ViewDataBinding, T: VideoViewHolder.VideoData>: DataBindingViewHolder<B, T> {

    @EntryPoint
    @InstallIn(ApplicationComponent::class)
    interface SingletonEntryPoint {
        fun exoplayer(): VideoPlayer
    }

    constructor(binding: B, action: Action): super(binding) {
        this.videoAction = action
    }

    constructor(parent: ViewGroup, @LayoutRes resId: Int, action: Action): super(parent, resId) {
        this.videoAction = action
    }

    open class VideoData(
        val videoId: Int,
        val videoUrl: String,
        val title: String,
    )

    abstract val playerView: PlayerView
    private val videoAction: Action

    private val videoPlayer: VideoPlayer = EntryPointAccessors.fromApplication(
        itemView.context,
        SingletonEntryPoint::class.java
    ).exoplayer()

    private val mediaSourceFactory: MediaSourceFactory

    private val videoEventListener = object: Player.Listener {
        override fun onPlaybackStateChanged(state: Int) {
            super.onPlaybackStateChanged(state)
            when (state) {
                Player.STATE_BUFFERING -> { }
                Player.STATE_READY -> { }
                Player.STATE_ENDED -> { }
                Player.STATE_IDLE -> { }
            }
        }
    }

    init {
        val userAgent = Util.getUserAgent(itemView.context, itemView.context.applicationInfo.name)
        val factory = DefaultDataSourceFactory(itemView.context, userAgent)
        mediaSourceFactory = ProgressiveMediaSource.Factory(factory)
    }

    override fun bindData(data: T?) {
        super.bindData(data)
        data?.let {
            // videoPlayer.setVideoUrl(it.videoUrl)
        }
    }

    interface Action {
        fun openVideo(data: VideoData)
        fun save(data: VideoData)
        fun share(data: VideoData)
        fun delete(data: VideoData)
    }

}