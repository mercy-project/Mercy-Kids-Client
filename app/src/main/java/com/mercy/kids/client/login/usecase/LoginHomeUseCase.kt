package com.mercy.kids.client.login.usecase

import android.content.Intent
import androidx.annotation.StringRes
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.material.snackbar.Snackbar
import com.mercy.kids.base.BaseActivityUseCase
import com.mercy.kids.client.login.activity.LoginHomeActivity
import javax.inject.Inject

class LoginHomeUseCase constructor(
        private val activity: LoginHomeActivity
): BaseActivityUseCase(activity) {

    companion object {
        private const val REQUEST_CODE_GOOGLE_SIGN_IN = 1000
    }

    fun startGoogleSignInFlow(signInIntent: Intent) {
        activity.startActivityForResult(signInIntent, REQUEST_CODE_GOOGLE_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) = when(requestCode) {
        REQUEST_CODE_GOOGLE_SIGN_IN -> {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            activity.viewModel.handleSignInResult(task)
            false
        }
        else -> super.onActivityResult(requestCode, resultCode, data)
    }

    fun snackBar(@StringRes message: Int) {
        Snackbar.make(activity.binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    fun snackBar(message: String) {
        Snackbar.make(activity.binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

}