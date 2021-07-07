package com.mercy.kids.component.extension

import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.databinding.BindingAdapter

object MotionLayoutExt {

    @BindingAdapter("transitionProgress")
    @JvmStatic
    fun MotionLayout.setTransitionProgress(transitionProgress: Float?) {
        transitionProgress?.let {
            this.progress = it
        }
    }

}