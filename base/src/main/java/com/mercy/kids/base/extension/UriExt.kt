package com.mercy.kids.base.extension

import android.net.Uri

val String?.parsedUri: Uri? get() = try {
    this?.let { Uri.parse(it) }
} catch (e: Exception) {
    null
}

fun Uri?.getParamMap(): Map<String, String> {
    val linkedHashMap = LinkedHashMap<String, String>()
    try {
        val pairs = this?.query?.run {
            split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        } ?: emptyArray()
        pairs.forEach {
            val idx = it.indexOf("=")
            linkedHashMap[it.substring(0, idx).utf8] = it.substring(idx+1).utf8
        }
    } catch (e: Exception) {
        e.log()
    }
    return linkedHashMap
}