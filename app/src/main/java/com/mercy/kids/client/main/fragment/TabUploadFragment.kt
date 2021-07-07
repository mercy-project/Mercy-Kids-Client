package com.mercy.kids.client.main.fragment

import android.os.Bundle
import android.view.View
import com.mercy.kids.base.component.DataBindingFragment
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.LayoutMainTabUploadBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabUploadFragment(
    override val layoutResId: Int = R.layout.layout_main_tab_upload
): DataBindingFragment<LayoutMainTabUploadBinding>() {

    override val bindingVariable: (LayoutMainTabUploadBinding) -> Unit = {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}