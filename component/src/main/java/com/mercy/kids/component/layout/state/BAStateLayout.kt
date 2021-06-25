package com.mercy.kids.component.layout.state

import androidx.databinding.BindingAdapter

object BAStateLayout {

    @JvmStatic
    @BindingAdapter("app:stateTag")
    fun StateLayout.setState(stateTag: String) {
        this.state = stateTag
    }

}