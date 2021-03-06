package com.mercy.kids.base

import android.app.Service
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

open class BaseActivityUseCase(
    private val activity: AppCompatActivity,
    private val rootView: View
) {

    protected val res: Resources get() = activity.resources

    fun resString(@StringRes id: Int) = res.getString(id)

    fun <T: AppCompatActivity> startActivity(activityClass: Class<T>, params: Bundle) {
        val intent = Intent(activity, activityClass).apply {
            putExtras(params)
        }
        activity.startActivity(intent)
    }

    fun finishActivity() {
        activity.finish()
    }

    fun <T: Service> startService (serviceClass: Class<T>, params: Bundle) {
        activity.startService(Intent(activity, serviceClass))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun <T: Service> startForegroundService(serviceClass: Class<T>, params: Bundle) {
        val intent = Intent(activity, serviceClass).apply {
            putExtras(params)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            activity.startForegroundService(intent)
        } else {
            activity.startService(intent)
        }
    }

    fun <T: Service> stopService(serviceClass: Class<T>) {
        activity.stopService(Intent(activity.applicationContext, serviceClass))
    }

    fun <T> getIntentValue(key: String) : T? {
        return activity.intent.extras?.get(key) as? T
    }

    fun snackBar(@StringRes message: Int) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
    }

    fun snackBar(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        return false
    }

}