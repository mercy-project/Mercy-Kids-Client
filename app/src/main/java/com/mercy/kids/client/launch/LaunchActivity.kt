package com.mercy.kids.client.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mercy.kids.client.account.activity.LoginHomeActivity
import com.mercy.kids.client.main.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity: AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        navigateToMainActivity()
    }

    private fun navigateToAccountService() {
        startActivity(Intent(this, LoginHomeActivity::class.java))
        finish()
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}