package com.mercy.kids.client.main.usecase

import com.mercy.kids.base.BaseActivityUseCase
import com.mercy.kids.client.main.activity.MainActivity
import javax.inject.Inject

class MainActivityUseCase @Inject constructor(
    activity: MainActivity
): BaseActivityUseCase(activity, activity.binding.root) {



}