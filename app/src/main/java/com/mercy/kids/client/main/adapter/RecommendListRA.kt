package com.mercy.kids.client.main.adapter

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.PopupMenu
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.google.android.exoplayer2.ui.PlayerView
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ItemVideoBinding
import com.mercy.kids.client.main.holder.VideoItemVH
import com.mercy.kids.component.video.VideoViewHolder
import javax.inject.Inject

object RecommendVideoComparator: DiffUtil.ItemCallback<RecommendListRA.Data>() {
    override fun areContentsTheSame(
        oldItem: RecommendListRA.Data,
        newItem: RecommendListRA.Data
    ): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(
        oldItem: RecommendListRA.Data,
        newItem: RecommendListRA.Data
    ): Boolean {
        return oldItem === newItem
    }
}

class RecommendListRA @Inject constructor(
    diffCallback: DiffUtil.ItemCallback<Data>,
    private val event: VideoItemVH.Event
): PagingDataAdapter<RecommendListRA.Data, VideoItemVH>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoItemVH {
        return VideoItemVH(parent, R.layout.item_video, event)
    }

    override fun onBindViewHolder(holder: VideoItemVH, position: Int) {
        val item = getItem(position)
        holder.bindData(item)
    }

    class Data(
        videoUrl: String,
        val title: String,
        val metadata: String,
        val channelThumbnail: String
    ): VideoViewHolder.VideoData(videoUrl) {

        override fun equals(other: Any?): Boolean {
            return if(other != null && other is Data) {
                this.videoUrl == other.videoUrl
                        && this.metadata == other.metadata
                        && this.title == other.title
                        && this.channelThumbnail == other.channelThumbnail
            } else false
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }

    }
}