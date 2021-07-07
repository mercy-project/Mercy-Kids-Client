package com.mercy.kids.client.account.viewmodel

import android.os.Bundle
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.google.android.gms.common.api.ApiException
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.base.extension.logException
import com.mercy.kids.base.extension.safeValue
import com.mercy.kids.client.R
import com.mercy.kids.client.account.activity.FindAccountActivity
import com.mercy.kids.client.account.activity.SignUpActivity
import com.mercy.kids.client.account.usecase.LoginHomeUseCase
import com.mercy.kids.repository.account.AccountRepository

class LoginHomeViewModel @ViewModelInject constructor(
    useCase: LoginHomeUseCase,
    private val repository: AccountRepository,
    @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<LoginHomeUseCase>(useCase) {

    private val _isLoading = MutableLiveData(false)

    val isLoading: LiveData<Boolean> = _isLoading

    val onFindAccountButtonClicked =  {
        useCase.startActivity(FindAccountActivity::class.java, Bundle())
    }

    val onSignUpButtonClicked = {
        useCase.startActivity(SignUpActivity::class.java, Bundle())
    }

    val startGoogleLoginFlow = {
        _isLoading.safeValue = true
        useCase.startGoogleSignInFlow()
    }

    fun handleSignInResult() = try {
        _isLoading.safeValue = false
    } catch (e: ApiException) {
        logException(e)
        useCase.snackBar(R.string.login_home_failed_google_signin)
    }

}