package com.mercy.kids.component.extension

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.mercy.kids.base.extension.logException

inline fun Context.getAttributes(
        attrs: IntArray,
        attributeSet: AttributeSet?,
        crossinline process: (TypedArray) -> Unit
) {
    var typedArray: TypedArray? = null
    try {
        typedArray = obtainStyledAttributes(attributeSet, attrs)
        process(typedArray)
    } catch (e: Exception) {
        logException(e)
    } finally {
        typedArray?.recycle()
    }
}