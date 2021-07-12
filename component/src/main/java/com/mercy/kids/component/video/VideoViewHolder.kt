package com.mercy.kids.component.video

import android.view.ViewGroup
import android.view.ViewParent
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
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

abstract class VideoViewHolder<B: ViewDataBinding, T: VideoViewHolder.VideoData>: DataBindingViewHolder<B, T> {

    @EntryPoint
    @InstallIn(ApplicationComponent::class)
    interface VideoPlayerProviderEntryPoint {
        fun exoplayer(): VideoPlayer
    }

    constructor(binding: B): super(binding)

    constructor(parent: ViewGroup, @LayoutRes resId: Int): super(parent, resId)

    open class VideoData(
        val videoUrl: String
    )

    abstract val playerView: PlayerView
    private val videoPlayer: VideoPlayer
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
        val hiltEntryPoint = EntryPointAccessors.fromApplication(
            itemView.context.applicationContext,
            VideoPlayerProviderEntryPoint::class.java
        )
        videoPlayer = hiltEntryPoint.exoplayer()

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

}