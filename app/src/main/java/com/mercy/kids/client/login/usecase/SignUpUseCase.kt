package com.mercy.kids.client.login.usecase

import com.mercy.kids.base.BaseActivityUseCase
import com.mercy.kids.client.login.activity.SignUpActivity
import javax.inject.Inject

class SignUpUseCase constructor(
        private val activity: SignUpActivity
): BaseActivityUseCase(activity)