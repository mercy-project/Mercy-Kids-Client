package com.mercy.kids.component.extension

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

fun Int.stringRes(context: Context): String {
    return try {
        context.getString(this)
    } catch (e: Exception) {
        ""
    }
}

fun Int.drawableRes(context: Context): Drawable? {
    return try {
        ContextCompat.getDrawable(context, this)
    } catch (e: Exception) {
        null
    }
}