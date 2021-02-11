package com.mercy.kids.component.edittext.signup

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseMethod
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

object BASignUpTextInput {

    @JvmStatic
    @BindingAdapter("app:textInputSubButtonText")
    fun SignUpTextInput.setTextInputSubButtonText(text: String?) {
        text?.let {
            subButtonText = it
        }
    }

    @JvmStatic
    @BindingAdapter("app:textInputCountDownTimer")
    fun SignUpTextInput.setTextInputCountDownTimer(text: String?) {
        text?.let {
            errorMessage = it
        }
    }

    @JvmStatic
    @BindingAdapter("app:textInputExternalValidator")
    fun SignUpTextInput.setTextInputValidator(validator: Validator?) {
        externalValidator = validator
    }

    @JvmStatic
    @BindingAdapter("app:textInputSubButtonClick")
    fun SignUpTextInput.setTextInputSubButtonClickFlow(onClick: (suspend (Boolean) -> Boolean)? = null) {
        subButtonClickFlow.onEach {
            if(isSubButtonFlowComplete) return@onEach
            isSubButtonLoading = true
            isSubButtonFlowComplete = onClick?.invoke(isSubButtonFlowComplete) ?: false
            isSubButtonLoading = false
        }.launchIn((context as LifecycleOwner).lifecycleScope)
    }

    @JvmStatic
    @BindingAdapter("app:textInputContent")
    fun SignUpTextInput.setTextInputContent(text: String? = null) {
        text?.let {
            this.text = text
        }
    }

}