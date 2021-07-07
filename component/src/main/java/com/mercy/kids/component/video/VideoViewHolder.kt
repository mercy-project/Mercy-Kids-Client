package com.mercy.kids.component.video

import androidx.databinding.ViewDataBinding
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.source.MediaSourceFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.mercy.kids.base.component.DataBindingViewHolder
import javax.inject.Inject

abstract class VideoViewHolder<T: VideoViewHolder.VideoData, B: ViewDataBinding>(
    binding: B
): DataBindingViewHolder<T, B>(binding) {

    @Inject lateinit var videoPlayer: VideoPlayer

    open class VideoData(
        val videoUrl: String
    )

    abstract val playerView: PlayerView
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
            videoPlayer.setVideoUrl(it.videoUrl)
        }
    }

}