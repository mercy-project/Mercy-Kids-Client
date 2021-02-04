package com.mercy.kids.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingActivity<V: ViewDataBinding>: AppCompatActivity() {

    lateinit var binding: V

    abstract val layoutResId: Int

    abstract val bindingVariable: (V) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        bindingVariable.invoke(binding)
    }

}