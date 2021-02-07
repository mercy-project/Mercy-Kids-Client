package com.mercy.kids.client.login.activity

import androidx.activity.viewModels
import com.mercy.kids.base.DataBindingActivity
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ActivityLoginHomeBinding
import com.mercy.kids.client.login.usecase.LoginHomeUseCase
import com.mercy.kids.client.login.viewmodel.LoginHomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginHomeActivity(
        override val layoutResId: Int = R.layout.activity_login_home
) : DataBindingActivity<ActivityLoginHomeBinding>() {

    private val viewModel by viewModels<LoginHomeViewModel>()

    private val useCase by lazy { LoginHomeUseCase(this) }

    override val bindingVariable: (ActivityLoginHomeBinding) -> Unit = {
        viewModel.useCase = useCase
        it.viewModel = viewModel
    }

}