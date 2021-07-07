package com.mercy.kids.client.main.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.base.extension.safeValue
import com.mercy.kids.client.main.usecase.MainActivityUseCase

class MainActivityViewModel @ViewModelInject constructor(
    useCase: MainActivityUseCase,
    @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<MainActivityUseCase>(useCase) {

    private val _motionLayoutProgress = MutableLiveData<Float>()

    val motionLayoutProgress: LiveData<Float> = _motionLayoutProgress


    fun setMotionLayoutProgress(progress: Float) {
        _motionLayoutProgress.safeValue = progress
    }

}