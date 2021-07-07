package com.mercy.kids.client.main.fragment

import com.mercy.kids.base.component.DataBindingFragment
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.LayoutMainTabRecommendBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabRecommendFragment(
    override val layoutResId: Int = R.layout.layout_main_tab_recommend
): DataBindingFragment<LayoutMainTabRecommendBinding>() {

    override val bindingVariable: (LayoutMainTabRecommendBinding) -> Unit = {

    }

}