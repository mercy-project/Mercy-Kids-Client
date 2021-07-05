package com.mercy.kids.client.account.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.base.extension.minuteSecond
import com.mercy.kids.base.extension.safeValue
import com.mercy.kids.base.extension.timerFlow
import com.mercy.kids.client.R
import com.mercy.kids.client.account.usecase.SignUpUseCase
import com.mercy.kids.repository.AccountRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import java.util.*
import kotlin.time.ExperimentalTime

class SignUpViewModel @ViewModelInject constructor(
    useCase: SignUpUseCase,
    private val accountRepository: AccountRepository,
    @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<SignUpUseCase>(useCase) {

    private var emailConfirmTimerJob: Job? = null

    private val _emailButtonText = MutableLiveData("")
    private val _emailConfirmRemainTime = MutableLiveData<String>()
    private val _emailConfirmButtonText = MutableLiveData("")

    val emailButtonText: LiveData<String> = _emailButtonText
    val emailConfirmRemainTime: LiveData<String> = _emailConfirmRemainTime
    val emailConfirmButtonText: LiveData<String> = _emailConfirmButtonText

    @ExperimentalTime
    val emailButtonClick: suspend (Boolean) -> Boolean = {
        delay(1000)
        val result = Random().nextBoolean()
        if(result) {
            _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_button_send)
            startEmailConfirmTimer(20)
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

    fun initialize() {
        _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_button)
        _emailConfirmButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_confirm_button)
    }

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    private fun startEmailConfirmTimer(max: Int) {
        emailConfirmTimerJob = viewModelScope.launch {
            timerFlow(1000L)
                    .take(max)
                    .map { max - it }
                    .onCompletion {
                        _emailConfirmRemainTime.safeValue = useCase.resString(R.string.sign_up_contents_email_confirm_expired)
                        _emailButtonText.safeValue = useCase.resString(R.string.sign_up_contents_email_button_resend)
                    }.collect {
                        _emailConfirmRemainTime.safeValue = it.minuteSecond
                    }
        }
    }

    override fun onCleared() {
        emailConfirmTimerJob?.cancel()
        super.onCleared()
    }

}