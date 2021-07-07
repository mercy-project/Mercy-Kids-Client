package com.mercy.kids.base.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class DataBindingFragment<V: ViewDataBinding>: Fragment() {

    abstract val layoutResId: Int

    lateinit var binding: V

    abstract val bindingVariable: (V) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutResId, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        bindingVariable(binding)
        return binding.root
    }

}