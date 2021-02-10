package com.mercy.kids.component.edittext.signup

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.annotation.StringRes
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.mercy.kids.component.databinding.ViewSignUpTextInputBinding

sealed class Validator(
    private val binding: ViewSignUpTextInputBinding
): TextWatcher {

    abstract val validate: ((CharSequence) -> Boolean)

    init {
        binding.tvSignUpErrorMessage.isGone = true
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

    override fun afterTextChanged(input: Editable?) = if(input as? CharSequence != null && input.isNotEmpty()) {
        binding.tvSignUpErrorMessage.isGone = validate.invoke(input)
    } else {
        binding.tvSignUpErrorMessage.isGone = true
    }

}

class NameValidator(binding: ViewSignUpTextInputBinding): Validator(binding) {
    override val validate: (CharSequence) -> Boolean = {
        it.length <= 100
    }
}

class EmailValidator(binding: ViewSignUpTextInputBinding): Validator(binding) {
    private val emailMatcher = Patterns.EMAIL_ADDRESS

    override val validate: (CharSequence) -> Boolean = {
        emailMatcher.matcher(it).matches()
    }
}

class EmailConfirmValidator(binding: ViewSignUpTextInputBinding): Validator(binding) {
    override val validate: (CharSequence) -> Boolean = {
        false
    }
}

class PasswordValidator(binding: ViewSignUpTextInputBinding): Validator(binding) {
    override val validate: (CharSequence) -> Boolean = {
        it.length >= 6
    }
}

class PasswordConfirmValidator(binding: ViewSignUpTextInputBinding): Validator(binding) {
    override val validate: (CharSequence) -> Boolean = {
        false
    }
}