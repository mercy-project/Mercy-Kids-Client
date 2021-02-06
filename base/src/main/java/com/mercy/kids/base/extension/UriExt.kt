package com.mercy.kids.base.extension

import android.net.Uri
import java.net.URLEncoder

val String.utf8: String get() = URLEncoder.encode(this, "UTF-8")
        .replace("-", "%2D")
        .replace(".", "%2E")

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