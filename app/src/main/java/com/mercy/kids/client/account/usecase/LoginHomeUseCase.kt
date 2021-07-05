package com.mercy.kids.client.account.usecase

import android.content.Intent
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import com.mercy.kids.base.BaseActivityUseCase
import com.mercy.kids.client.account.activity.LoginHomeActivity
import javax.inject.Inject

class LoginHomeUseCase @Inject constructor(
        activity: LoginHomeActivity
): BaseActivityUseCase(activity, activity.binding.root) {

    companion object {
        private const val REQUEST_CODE_GOOGLE_SIGN_IN = 1000
    }

    fun startGoogleSignInFlow() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) = when(requestCode) {
        REQUEST_CODE_GOOGLE_SIGN_IN -> {
            super.onActivityResult(requestCode, resultCode, data)
        }
        else -> super.onActivityResult(requestCode, resultCode, data)
    }


}