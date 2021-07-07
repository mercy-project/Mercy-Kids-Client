package com.mercy.kids.client.account.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.base.extension.safeValue
import com.mercy.kids.client.account.usecase.FindAccountUseCase
import com.mercy.kids.repository.account.AccountRepository

class FindAccountViewModel @ViewModelInject constructor(
    useCase: FindAccountUseCase,
    private val accountRepository: AccountRepository,
    @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<FindAccountUseCase>(useCase) {

    private val _findEmailStateTag = MutableLiveData("view_normal")

    val findEmailStateTag: LiveData<String> = _findEmailStateTag

    val confirmCheckEmailAddress: () -> Unit = {
        if(java.util.Random().nextBoolean()) {
            _findEmailStateTag.safeValue = "view_exist"
        } else {
            _findEmailStateTag.safeValue = "view_empty"
        }
    }

    val retryCheckEmailAddress: () -> Unit = {
        _findEmailStateTag.safeValue = "view_normal"
    }
}