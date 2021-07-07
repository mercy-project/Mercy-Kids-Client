package com.mercy.kids.base.component

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
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

    open fun setToolbar(toolbar: Toolbar, @DrawableRes homeIconRes: Int? = null) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        homeIconRes?.let {
            supportActionBar?.setHomeAsUpIndicator(it)
        }
    }

}