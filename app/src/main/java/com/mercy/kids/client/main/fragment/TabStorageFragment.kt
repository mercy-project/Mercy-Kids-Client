package com.mercy.kids.client.main.fragment

import android.os.Bundle
import android.view.View
import com.mercy.kids.base.component.DataBindingFragment
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.LayoutMainTabStorageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabStorageFragment(
    override val layoutResId: Int = R.layout.layout_main_tab_storage
): DataBindingFragment<LayoutMainTabStorageBinding>() {

    override val bindingVariable: (LayoutMainTabStorageBinding) -> Unit = {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}