package com.mercy.kids.client.login.activity

import androidx.activity.viewModels
import com.mercy.kids.base.DataBindingActivity
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ActivityLoginHomeBinding
import com.mercy.kids.client.login.viewmodel.LoginHomeViewModel

class LoginHomeActivity(
        override val layoutResId: Int = R.layout.activity_login_home
) : DataBindingActivity<ActivityLoginHomeBinding>() {

    private val viewModel by viewModels<LoginHomeViewModel>()

    override val bindingVariable: (ActivityLoginHomeBinding) -> Unit = {
        it.viewModel = viewModel
    }

}