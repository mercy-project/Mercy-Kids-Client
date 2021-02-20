package com.mercy.kids.client.login.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.appbar.AppBarLayout
import com.mercy.kids.base.DataBindingActivity
import com.mercy.kids.base.extension.logMessage
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ActivitySignUpBinding
import com.mercy.kids.client.login.usecase.SignUpUseCase
import com.mercy.kids.client.login.viewmodel.SignUpViewModel
import com.mercy.kids.component.edittext.signup.PasswordConfirmValidator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity(
        override val layoutResId: Int = R.layout.activity_sign_up
) : DataBindingActivity<ActivitySignUpBinding>() {

    private val viewModel by viewModels<SignUpViewModel>()

    private val useCase by lazy { SignUpUseCase(this) }

    override val bindingVariable: (ActivitySignUpBinding) -> Unit = {
        viewModel.useCase = useCase
        it.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar(binding.layoutSignUpToolbar.tbSignUp, R.drawable.ic_baseline_arrow_back_24)
        viewModel.initialize()
        setExternalValidator()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }

    private fun setExternalValidator() = with(binding.layoutSignUpContent) {
        textInputSignUpPasswordConfirm.externalValidator = PasswordConfirmValidator(textInputSignUpPasswordConfirm) {
            return@PasswordConfirmValidator it.toString() == textInputSignUpPassword.text
        }
    }

}

