package com.mercy.kids.component.edittext

import com.mercy.kids.base.extension.dp
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.mercy.kids.component.databinding.ViewLoginHomeEditTextBinding

class LoginHomeEditText @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attributeSet, defStyleAttr), TextWatcher {

    private val binding = ViewLoginHomeEditTextBinding.inflate(LayoutInflater.from(context), this)

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        setPadding(context.dp(4), context.dp(4), context.dp(4), context.dp(4))

        binding.etTextValidationInput.addTextChangedListener(this)
    }

    override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(editable: Editable?) {

    }
}
