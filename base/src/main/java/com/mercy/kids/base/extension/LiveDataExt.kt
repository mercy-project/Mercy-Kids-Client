package com.mercy.kids.base.extension

import androidx.lifecycle.MutableLiveData
import java.lang.Exception

var <T> MutableLiveData<T>.safeValue
    get() = this.value
    set(value) = try {
        this.value = value
    } catch (e: IllegalStateException) {
        this.postValue(value)
    } catch (e: Exception) {
        this.postValue(value)
    }
