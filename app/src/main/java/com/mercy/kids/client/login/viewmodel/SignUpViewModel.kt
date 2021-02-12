package com.mercy.kids.client.login.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.base.extension.safeValue
import com.mercy.kids.client.R
import com.mercy.kids.client.login.usecase.SignUpUseCase
import kotlinx.coroutines.delay
import java.util.*

class SignUpViewModel @ViewModelInject constructor(
        @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<SignUpUseCase>() {

    private val _emailButtonText = MutableLiveData("")
    private val _emailConfirmButtonText = MutableLiveData("")

    val emailButtonText: LiveData<String> = _emailButtonText
    val emailConfirmButtonText: LiveData<String> = _emailConfirmButtonText

    val emailButtonClick: suspend (Boolean) -> Boolean = {
        delay(1000)
        val result = Random().nextBoolean()
        if(result) {
            _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_button_send)
        } else {
            _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_button_resend)
        }
        result
    }

    val emailConfirmButtonClick: suspend (Boolean) -> Boolean = {
        delay(1000)
        val result = Random().nextBoolean()
        if(result) {
            _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_confirm_button_ok)
            _emailConfirmButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_confirm_button_ok)
        } else {
            _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_button_resend)
            _emailConfirmButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_confirm_button)
        }
        result
    }

    val validatePasswordConfirm: (CharSequence) -> Boolean = { input ->
        false
    }

    fun initialize() {
        _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_button)
        _emailConfirmButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_confirm_button)
    }
}