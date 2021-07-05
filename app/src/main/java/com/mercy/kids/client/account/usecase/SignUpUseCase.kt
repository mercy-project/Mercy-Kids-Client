package com.mercy.kids.client.account.usecase

import com.mercy.kids.base.BaseActivityUseCase
import com.mercy.kids.client.account.activity.SignUpActivity
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
        activity: SignUpActivity
): BaseActivityUseCase(activity, activity.binding.root)