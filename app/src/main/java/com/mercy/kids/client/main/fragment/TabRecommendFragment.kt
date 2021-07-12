package com.mercy.kids.client.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.mercy.kids.base.component.DataBindingFragment
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.LayoutMainTabRecommendBinding
import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.client.main.holder.VideoItemVH
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

    override fun openChannelInfo(data: RecommendListRA.Data) {

    }

}