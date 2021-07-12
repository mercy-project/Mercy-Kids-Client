package com.mercy.kids.client.main.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.mercy.kids.base.component.DataBindingFragment
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.LayoutMainTabRecommendBinding
import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.client.main.holder.VideoItemVH
import com.mercy.kids.client.main.usecase.Mapper
import com.mercy.kids.client.main.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TabRecommendFragment(
    override val layoutResId: Int = R.layout.layout_main_tab_recommend
): DataBindingFragment<LayoutMainTabRecommendBinding>(), VideoItemVH.Event {

    private val activityViewModel: MainActivityViewModel by activityViewModels()

    @Inject lateinit var adapter: RecommendListRA

    override val bindingVariable: (LayoutMainTabRecommendBinding) -> Unit = {
        it.contentList.adapter = this.adapter
        it.swipeLayout.setOnRefreshListener(loadRecommendVideoList)
    }

    private val loadRecommendVideoList: () -> Unit =  {
        lifecycleScope.launch {
            activityViewModel.recommendVideoData.collectLatest { data ->
                adapter.submitData(data)
                binding.swipeLayout.isRefreshing = false
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadRecommendVideoList()
    }

    override fun onItemClicked(data: RecommendListRA.Data) {
        activity?.supportFragmentManager?.let {
            val videoPlayerFragment = it.findFragmentById(R.id.video_player_fragment_container) as VideoPlayerFragment
            it.beginTransaction()
                .setCustomAnimations(R.anim.transition_open_video_player, R.anim.nav_default_pop_exit_anim)
                .show(videoPlayerFragment)
                .commit()
        }
    }

    override fun saveVideoItem(data: RecommendListRA.Data) {

    }

    override fun shareVideoUrl(data: RecommendListRA.Data) {

    }

    override fun deleteVideo(data: RecommendListRA.Data) {

    }

}