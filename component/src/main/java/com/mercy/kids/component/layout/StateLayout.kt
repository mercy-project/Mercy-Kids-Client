package com.mercy.kids.component.layout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import com.mercy.kids.base.extension.logMessage

class StateLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
): ConstraintLayout(context, attrs) {

    /**
     * State 에 따라 visibility 를 다르게 설정할 수 있는 레이아웃.
     * 어떻게 구현할 것인가?
     */

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        // TODO(여기서 children 받아올 수 있다)
    }

    fun setState(state: Any) {
        // TODO()
    }

}