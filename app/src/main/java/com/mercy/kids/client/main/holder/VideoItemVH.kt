package com.mercy.kids.client.main.holder

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.PopupMenu
import com.google.android.exoplayer2.ui.PlayerView
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ItemVideoBinding
import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.component.video.VideoViewHolder

class VideoItemVH(
    parent: ViewGroup,
    @LayoutRes resId: Int,
    videoAction: Action,
    private val viewHolderEvent: Event,
): VideoViewHolder<ItemVideoBinding, RecommendListRA.Data>(parent, resId, videoAction) {

    override val playerView: PlayerView = binding.thumbnailPlayer

    init {
        binding.root.setOnClickListener {
            itemData?.let {
                videoAction.openVideo(it)
            }
        }

        binding.videoDescription.menuItemClickListener = PopupMenu.OnMenuItemClickListener { item ->
            return@OnMenuItemClickListener when(item.itemId) {
                R.id.menu_video_desc_save -> itemData?.let {
                    videoAction.save(it)
                    true
                } ?: false
                R.id.menu_video_desc_share -> itemData?.let {
                    videoAction.share(it)
                    true
                } ?: false
                R.id.menu_video_desc_delete -> itemData?.let {
                    videoAction.delete(it)
                    true
                } ?: false
                else -> false
            }
        }
    }

    override fun bindData(data: RecommendListRA.Data?) {
        super.bindData(data)
        data?.let {
            binding.videoDescription.title = it.title
            binding.videoDescription.metadata = it.metadata
            binding.videoDescription.channelThumbnail = it.channelThumbnail
        }
    }

    interface Event {
        fun openChannelInfo(data: RecommendListRA.Data)
    }

}