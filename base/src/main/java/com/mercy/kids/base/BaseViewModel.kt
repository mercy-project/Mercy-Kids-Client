package com.mercy.kids.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<U: BaseActivityUseCase>(val useCase: U): ViewModel()