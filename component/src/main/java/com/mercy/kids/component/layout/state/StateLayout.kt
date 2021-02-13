package com.mercy.kids.component.layout.state

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.mercy.kids.component.R
import com.mercy.kids.component.extension.getAttributes

class StateLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
): ConstraintLayout(context, attrs) {

    private var stateList = listOf<String>()

    private var viewMap = mutableMapOf<String, View>()

    private var initialState: String = ""

    var state: String? = null
        set(value) {
            viewMap.keys.forEach {
                viewMap[it]?.isVisible = it == value
            }
            field = value
        }

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setData(attrs)
    }

    private fun setData(attributeSet: AttributeSet?) = context.getAttributes(R.styleable.StateLayout, attributeSet) {
        stateList = it.getString(R.styleable.StateLayout_stateTags).parseStringToList()
        initialState = it.getString(R.styleable.StateLayout_initialState) ?: stateList.firstOrNull() ?: ""
    }

    private fun String?.parseStringToList() = if(this.isNullOrEmpty()) {
        listOf()
    } else {
        this.split(",")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        stateList.forEach {
            viewMap[it] = findViewWithTag(it)
        }
        if(initialState.isNotEmpty()) {
            state = initialState
        }
    }

}