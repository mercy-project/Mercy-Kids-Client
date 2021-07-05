package com.mercy.kids.client.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mercy.kids.client.account.activity.LoginHomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity: AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        navigateToAccountService()
    }

    private fun navigateToAccountService() {
        startActivity(Intent(this, LoginHomeActivity::class.java))
        finish()
    }

}