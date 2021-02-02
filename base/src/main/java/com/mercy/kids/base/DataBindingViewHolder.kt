package com.mercy.kids.base

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

    abstract fun bindData(data: T)

}