package com.mercy.kids.client.login.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.client.login.usecase.SignUpUseCase

class SignUpViewModel @ViewModelInject constructor(
        @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<SignUpUseCase>() {



}