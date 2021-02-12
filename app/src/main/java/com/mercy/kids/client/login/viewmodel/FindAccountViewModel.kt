package com.mercy.kids.client.login.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.client.login.usecase.FindAccountUseCase

class FindAccountViewModel @ViewModelInject constructor(
        @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<FindAccountUseCase>() {




}