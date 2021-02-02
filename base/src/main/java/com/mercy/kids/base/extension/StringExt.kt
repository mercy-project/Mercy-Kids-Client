package com.mercy.kids.base.extension

import java.net.URLEncoder

val String.utf8: String get() = URLEncoder.encode(this, "UTF-8")
    .replace("-", "%2D")
    .replace(".", "%2E")