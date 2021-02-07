package com.mercy.kids.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<U: BaseActivityUseCase>: ViewModel() {

    lateinit var useCase: U

}