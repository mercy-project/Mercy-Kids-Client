package com.mercy.kids.client.login.viewmodel

import android.os.Bundle
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.base.extension.logException
import com.mercy.kids.base.extension.logMessage
import com.mercy.kids.base.extension.safeValue
import com.mercy.kids.client.R
import com.mercy.kids.client.login.activity.FindAccountActivity
import com.mercy.kids.client.login.activity.SignUpActivity
import com.mercy.kids.client.login.usecase.LoginHomeUseCase

class LoginHomeViewModel @ViewModelInject constructor(
        val googleSignInClient: GoogleSignInClient,
        @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<LoginHomeUseCase>() {

    private val _isLoading = MutableLiveData(false)

    val isLoading: LiveData<Boolean> = _isLoading

    val onFindAccountButtonClicked =  {
        useCase.startActivity(FindAccountActivity::class.java, Bundle())
    }

    val onSignUpButtonClicked = {
        _isLoading.safeValue = true
        useCase.startActivity(SignUpActivity::class.java, Bundle())
    }

    val startGoogleLoginFlow = {
        useCase.startGoogleSignInFlow(googleSignInClient.signInIntent)
    }

    fun handleSignInResult(signInTask: Task<GoogleSignInAccount>) = try {
        _isLoading.safeValue = false
        sendSignedAccountToServer(signInTask.getResult(ApiException::class.java))
    } catch (e: ApiException) {
        logException(e)
        useCase.snackBar(R.string.login_home_failed_google_signin)
    }

    private fun sendSignedAccountToServer(account: GoogleSignInAccount?) = account?.let {
        logMessage(it.email ?: "null")
    } ?: run {
        // TODO(구글 로그인 success 콜백 받았으나 account 객체가 없는 경우
    }

}