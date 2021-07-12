package com.mercy.kids.client.main.holder

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.PopupMenu
import com.google.android.exoplayer2.ui.PlayerView
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ItemVideoBinding
import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.component.video.VideoViewHolder
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Inject

class VideoItemVH(
    parent: ViewGroup,
    @LayoutRes resId: Int,
    event: Event
): VideoViewHolder<ItemVideoBinding, RecommendListRA.Data>(parent, resId) {

    override val playerView: PlayerView = binding.thumbnailPlayer

    init {
        binding.root.setOnClickListener {
            itemData?.let {
                event.onItemClicked(it)
            }
        }

        binding.videoDescription.menuItemClickListener = PopupMenu.OnMenuItemClickListener { item ->
            return@OnMenuItemClickListener when(item.itemId) {
                R.id.menu_video_desc_save -> itemData?.let {
                    event.saveVideoItem(it)
                    true
                } ?: false
                R.id.menu_video_desc_share -> itemData?.let {
                    event.shareVideoUrl(it)
                    true
                } ?: false
                R.id.menu_video_desc_delete -> itemData?.let {
                    event.deleteVideo(it)
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
        fun onItemClicked(data: RecommendListRA.Data)
        fun saveVideoItem(data: RecommendListRA.Data)
        fun shareVideoUrl(data: RecommendListRA.Data)
        fun deleteVideo(data: RecommendListRA.Data)
    }

}