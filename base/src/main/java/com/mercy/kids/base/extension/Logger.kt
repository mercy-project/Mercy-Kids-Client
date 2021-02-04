package com.mercy.kids.base.extension

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.mercy.kids.base.BuildConfig

fun Any.logMessage(message: String?) {
    if(BuildConfig.DEBUG) {
        Log.d(this::class.java.simpleName, message ?: "unknown message")
    } else {
        FirebaseCrashlytics.getInstance().logMessage(message)
    }
}

fun Any.logException(t: Throwable) {
    logException(Exception(t))
}

fun Any.logException(e: Exception) {
    if(BuildConfig.DEBUG) {
        e.printStackTrace()
    } else {
        FirebaseCrashlytics.getInstance().recordException(e)
    }
}

fun Exception.log() {
    if(BuildConfig.DEBUG) {
        printStackTrace()
    } else {
        FirebaseCrashlytics.getInstance().recordException(this)
    }
}

fun Throwable.log() {
    logException(Exception(this))
}