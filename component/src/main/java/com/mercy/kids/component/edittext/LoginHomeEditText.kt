package com.mercy.kids.component.edittext

import com.mercy.kids.base.extension.dp
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.mercy.kids.component.databinding.ViewLoginHomeEditTextBinding

class LoginHomeEditText @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attributeSet, defStyleAttr) {

    private val binding = ViewLoginHomeEditTextBinding.inflate(LayoutInflater.from(context), this)

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        setPadding(context.dp(4), context.dp(4), context.dp(4), context.dp(4))
    }

}
