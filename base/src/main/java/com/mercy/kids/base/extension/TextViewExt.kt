package com.mercy.kids.base.extension

import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

fun TextView.removeCompoundDrawables() {
    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
}

fun TextView.setDrawableLeft(@DrawableRes resId: Int) {
    setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0)
}

fun TextView.setDrawableRight(@DrawableRes resId: Int) {
    setCompoundDrawablesWithIntrinsicBounds(0, 0, resId, 0)
}

fun TextView.setTextResWithState(@StringRes textRes: Int?, nullState: Int = View.GONE) = textRes?.let {
    val targetStr = try { context.getString(it) } catch (e: Exception) { null }
    setTextWithState(targetStr, nullState)
} ?: run {
    setTextWithState(null, nullState)
}

fun TextView.setTextWithState(text: String? = null, nullState: Int = View.GONE) = text?.let {
    this.text = it
    this.visibility = View.VISIBLE
} ?: run {
    visibility = nullState
}