package com.mercy.kids.component.edittext

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.mercy.kids.base.extension.*
import com.mercy.kids.component.R
import com.mercy.kids.component.databinding.ViewLoginHomeTextInputBinding
import com.mercy.kids.component.extension.getAttributes

class LoginHomeTextInput @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
): ConstraintLayout(context, attributeSet) {

    data class Model(
            @StringRes val hint: Int = 0,
            @StringRes val errorMessage: Int = 0,
            val errorEnabled: Boolean = false,
            @DrawableRes val errorIcon: Int = 0,
            @DrawableRes val validIcon: Int = 0
    )

    private val binding = ViewLoginHomeTextInputBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setData(attributeSet)
        setTextValidator(binding.data)
    }

    private fun setData(attributeSet: AttributeSet?) = context.getAttributes(R.styleable.LoginHomeTextInput, attributeSet) {
        val hint = it.getResourceId(R.styleable.LoginHomeTextInput_textInputHint, 0)
        val errorMessage = it.getResourceId(R.styleable.LoginHomeTextInput_textInputErrorMessage, 0)
        val errorEnabled = it.getBoolean(R.styleable.LoginHomeTextInput_textInputErrorEnabled, false)
        val errorIcon = it.getResourceId(R.styleable.LoginHomeTextInput_textInputErrorIcon, R.drawable.ic_baseline_error_outline_24)
        val validIcon = it.getResourceId(R.styleable.LoginHomeTextInput_textInputValidIcon, R.drawable.ic_baseline_check_circle_outline_24)
        binding.data = Model(hint, errorMessage, errorEnabled, errorIcon, validIcon)
    }

    private fun setTextValidator(data: Model?) = data?.let {
        if(it.errorEnabled) {
            binding.etLoginHomeTextInput.addTextChangedListener(EmailValidator(binding, data))
            binding.etLoginHomeTextInput.inputType = InputType.TYPE_CLASS_TEXT
            binding.ivLoginHomeValidIndicator.visibility = View.VISIBLE
        } else {
            binding.etLoginHomeTextInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            binding.ivLoginHomeValidIndicator.visibility = View.INVISIBLE
        }
    }

    private class EmailValidator(
            private val binding: ViewLoginHomeTextInputBinding,
            data: Model
    ): TextWatcher {

        private val emailMatcher = Patterns.EMAIL_ADDRESS
        @StringRes private val errorMessage = data.errorMessage
        @DrawableRes private val errorIcon = data.errorIcon
        @DrawableRes private val validIcon = data.validIcon

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun afterTextChanged(input: Editable?) = if(input as? CharSequence != null && input.isNotEmpty()) {
            if(emailMatcher.matcher(input).matches()) {
                binding.tvLoginHomeInputInvalidMessage.setTextResWithState(null)
                binding.etLoginHomeTextInput.setBackgroundResource(R.drawable.login_home_edittext_bg)
                binding.ivLoginHomeValidIndicator.setImageResWithState(validIcon, INVISIBLE)
            } else {
                binding.tvLoginHomeInputInvalidMessage.setTextResWithState(errorMessage)
                binding.etLoginHomeTextInput.setBackgroundResource(R.drawable.login_home_edittext_bg_error)
                binding.ivLoginHomeValidIndicator.setImageResWithState(errorIcon, INVISIBLE)
            }
        } else {
            binding.tvLoginHomeInputInvalidMessage.setTextResWithState(null)
            binding.etLoginHomeTextInput.setBackgroundResource(R.drawable.login_home_edittext_bg)
            binding.ivLoginHomeValidIndicator.setImageResWithState(null, INVISIBLE)
        }
    }
}