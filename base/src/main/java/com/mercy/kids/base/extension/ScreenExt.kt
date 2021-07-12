package com.mercy.kids.base.extension

import android.content.Context
import kotlin.math.roundToInt

fun Context.dp(dp: Int) = (dp * resources.displayMetrics.density).roundToInt()

fun Context.dp(dp: Float) = (dp * resources.displayMetrics.density)

fun Context.dp(dp: Double) = (dp * resources.displayMetrics.density)

fun Int.dp(context: Context) = context.dp(this)

fun Float.dp(context: Context) = context.dp(this)

fun Double.dp(context: Context) = context.dp(this)