package com.mercy.kids.client.account.activity

import android.content.Intent
import androidx.activity.viewModels
import com.mercy.kids.base.component.DataBindingActivity
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ActivityLoginHomeBinding
import com.mercy.kids.client.account.viewmodel.LoginHomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginHomeActivity(
    override val layoutResId: Int = R.layout.activity_login_home
): DataBindingActivity<ActivityLoginHomeBinding>() {

    val viewModel by viewModels<LoginHomeViewModel>()

    override val bindingVariable: (ActivityLoginHomeBinding) -> Unit = {
        it.viewModel = viewModel
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.useCase.onActivityResult(requestCode, resultCode, data)
    }

}