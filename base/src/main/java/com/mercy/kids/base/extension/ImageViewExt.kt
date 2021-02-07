package com.mercy.kids.base.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun ImageView.setImageResWithState(@DrawableRes imageRes: Int?, nullState: Int = View.GONE) = imageRes?.let {
    val drawable = try { ContextCompat.getDrawable(context, it) } catch (e: Exception) { null }
    setImageWithState(drawable, nullState)
} ?: run {
    setImageWithState(null, nullState)
}

fun ImageView.setImageWithState(drawable: Drawable?, nullState: Int = View.GONE) = drawable?.let {
    this.setImageDrawable(it)
    visibility = View.VISIBLE
} ?: run {
    visibility = nullState
}