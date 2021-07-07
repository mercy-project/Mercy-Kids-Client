package com.mercy.kids.base.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class DataBindingViewHolder<T: Any, B: ViewDataBinding>(
    val binding: B
): RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, @LayoutRes resId: Int): this(
        DataBindingUtil.inflate<B>(
            LayoutInflater.from(parent.context),
            resId,
            parent,
            false
        )
    )

    protected var itemData: T? = null
    protected var isAttached: Boolean = false
        private set

    open fun bindData(data: T?) {
        itemData = data
    }

    open fun onAttachedToWindow() {
        isAttached = true
    }

    open fun onDetachedToWindow() {
        isAttached = false
    }

    open fun onViewRecycled() = Unit

}