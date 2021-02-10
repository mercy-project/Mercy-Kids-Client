package com.mercy.kids.component.extension

import android.widget.EditText
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.mercy.kids.base.extension.setTextResWithState

object TextViewExt {

    @JvmStatic
    @BindingAdapter("safeTextRes")
    fun TextView.setSafeTextRes(@StringRes id: Int? = null) {
        id?.let {
            setTextResWithState(id)
        }
    }

    @JvmStatic
    @BindingAdapter("safeHintRes")
    fun EditText.setSafeHintRes(@StringRes id: Int? = null) {
        id ?: return
        try {
            this.setHint(id)
        } catch (e: Exception) {
            this.hint = ""
        }
    }
}