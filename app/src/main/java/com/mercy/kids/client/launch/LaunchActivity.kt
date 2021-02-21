package com.mercy.kids.client.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.mercy.kids.client.login.activity.LoginHomeActivity
import com.mercy.kids.client.main.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity: AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        checkGoogleSignInAccountExist()
    }

    private fun checkGoogleSignInAccountExist() = GoogleSignIn.getLastSignedInAccount(this)?.let {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    } ?: run {
        startActivity(Intent(this, LoginHomeActivity::class.java))
        finish()
    }

}