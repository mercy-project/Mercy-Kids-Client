package com.mercy.kids.client.login.viewmodel

import android.os.Bundle
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.client.login.activity.FindAccountActivity
import com.mercy.kids.client.login.activity.SignUpActivity
import com.mercy.kids.client.login.usecase.LoginHomeUseCase

class LoginHomeViewModel @ViewModelInject constructor(
        val googleSignInClient: GoogleSignInClient,
        @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<LoginHomeUseCase>() {

    val onFindAccountButtonClicked =  {
        useCase.startActivity(FindAccountActivity::class.java, Bundle())
    }

    val onSignUpButtonClicked = {
        useCase.startActivity(SignUpActivity::class.java, Bundle())
    }

    val startGoogleLoginFlow = {





    }
}