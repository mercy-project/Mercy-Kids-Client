package com.mercy.kids.base.extension

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import java.lang.Exception
import java.util.*
import java.util.concurrent.TimeUnit

@ExperimentalCoroutinesApi
fun timerFlow(millis: Long) = callbackFlow<Long> {
    val timer = Timer()
    var time = 0L
    timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    try {
                        offer(time)
                    } catch (e: Exception) {
                        logException(e)
                    }
                    time += 1
                }
            },
            0,
            millis
    )
    awaitClose {
        timer.cancel()
    }
}

val Long.minuteSecond: String get() {
    val min = TimeUnit.SECONDS.toMinutes(this)
    val sec = TimeUnit.SECONDS.toSeconds(this) - (min * 60)
    return String.format("%02d:%02d", min, sec)
}