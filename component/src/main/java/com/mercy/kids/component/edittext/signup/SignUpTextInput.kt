package com.mercy.kids.component.edittext.signup

import android.content.Context
import android.graphics.Color
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.mercy.kids.base.extension.dp
import com.mercy.kids.base.extension.setTextResWithState
import com.mercy.kids.component.R
import com.mercy.kids.component.databinding.ViewSignUpTextInputBinding
import com.mercy.kids.component.extension.getAttributes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import reactivecircus.flowbinding.android.view.clicks

class SignUpTextInput @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
): ConstraintLayout(context, attrs) {

    /**
     * @see attrs.xml
     * SignUpTextInput 의 declare-styleable 에 선언된 커스텀 속성의 @textInputType 하위 enum 값이
     * 이 enum class 와 동일해야 합니다.
     */
    enum class Type(val type: Int) {
        PLAIN_TEXT(0),
        NAME(1),
        EMAIL(2),
        EMAIL_CONFIRM(3),
        PASSWORD(4),
        PASSWORD_CONFIRM(5),
        BIRTH(6),
        PHONE(7)
    }

    data class Model(
            @StringRes val hint: Int = 0,
            @StringRes val title: Int = 0,
            val inputType: Type = Type.PLAIN_TEXT
    )

    private val binding = ViewSignUpTextInputBinding.inflate(LayoutInflater.from(context), this, true)

    var subButtonText: CharSequence = ""
        get() = binding.btnSignUpSubButton.text
        set(value) {
            binding.btnSignUpSubButton.text = value
            field = value
        }

    var errorMessage: CharSequence = ""
        get() = binding.tvSignUpErrorMessage.text
        set(value) {
            binding.tvSignUpErrorMessage.text = value
            field = value
        }

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setPadding(0, context.dp(8), 0, 0)
        setData(attrs)

        binding.data?.let {
            setTextValidator(it)
            setTextInputType(it)
        }
    }

    val subButtonClickFlow: Flow<Unit> = binding.btnSignUpSubButton.clicks()
        .onStart {
            binding.pbSignUpSubButtonProgress.isVisible = true
        }.onCompletion {
            binding.pbSignUpSubButtonProgress.isVisible = false
        }

    fun setSubButtonBackgroundColor(@ColorRes id: Int) {
        binding.btnSignUpSubButton.backgroundTintList = ContextCompat.getColorStateList(context, id)
    }

    private fun setData(attrs: AttributeSet?) = context?.getAttributes(R.styleable.SignUpTextInput, attrs) {
        val hint = it.getResourceId(R.styleable.SignUpTextInput_textInputHint, 0)
        val title = it.getResourceId(R.styleable.SignUpTextInput_textInputTitle, 0)
        val subButtonNormalText = it.getResourceId(R.styleable.SignUpTextInput_textInputSubButtonText, 0)
        val errorMessage = it.getResourceId(R.styleable.SignUpTextInput_textInputErrorMessage, 0)
        val inputType = it.getInt(R.styleable.SignUpTextInput_textInputType, 0).inputType

        binding.data = Model(hint, title, inputType)
        binding.tvSignUpErrorMessage.setTextResWithState(errorMessage)
        binding.btnSignUpSubButton.setTextResWithState(subButtonNormalText)
    }

    private fun setTextValidator(data: Model) {
        when(data.inputType) {
            Type.NAME -> binding.etSignUpTextInput.addTextChangedListener(NameValidator(binding))
            Type.EMAIL -> binding.etSignUpTextInput.addTextChangedListener(EmailValidator(binding))
            Type.EMAIL_CONFIRM -> binding.etSignUpTextInput.addTextChangedListener(EmailConfirmValidator(binding))
            Type.PASSWORD -> binding.etSignUpTextInput.addTextChangedListener(PasswordValidator(binding))
            Type.PASSWORD_CONFIRM -> binding.etSignUpTextInput.addTextChangedListener(PasswordConfirmValidator(binding))
            else -> {
                // do nothing
            }
        }
    }

    private fun setTextInputType(data: Model) {
        when(data.inputType) {
            Type.PASSWORD, Type.PASSWORD_CONFIRM -> {
                binding.etSignUpTextInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            Type.BIRTH -> {
                binding.etSignUpTextInput.isFocusable = false
            }
            Type.PHONE -> {
                binding.etSignUpTextInput.inputType = InputType.TYPE_CLASS_PHONE
            }
            else -> {
                binding.etSignUpTextInput.inputType = InputType.TYPE_CLASS_TEXT
            }
        }
    }

    private val Int.inputType get() = when(this) {
        Type.NAME.type -> Type.NAME
        Type.EMAIL.type -> Type.EMAIL
        Type.EMAIL_CONFIRM.type -> Type.EMAIL_CONFIRM
        Type.PASSWORD.type -> Type.PASSWORD
        Type.PASSWORD_CONFIRM.type -> Type.PASSWORD_CONFIRM
        Type.BIRTH.type -> Type.BIRTH
        Type.PHONE.type -> Type.PHONE
        Type.PLAIN_TEXT.type -> Type.PLAIN_TEXT
        else -> Type.PLAIN_TEXT
    }

}