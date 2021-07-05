package com.mercy.kids.client.account.usecase

import com.mercy.kids.base.BaseActivityUseCase
import com.mercy.kids.client.account.activity.FindAccountActivity
import javax.inject.Inject

class FindAccountUseCase @Inject constructor(
        activity: FindAccountActivity
): BaseActivityUseCase(activity, activity.binding.root) {


}