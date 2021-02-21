package com.mercy.kids.client.di

import androidx.fragment.app.FragmentActivity
import com.mercy.kids.client.login.fragment.FindAccountPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    companion object {

        @Provides
        fun provideAccountPagerAdapter(activity: FragmentActivity) = FindAccountPagerAdapter(activity)

        @Provides
        fun provideGoogleSignInClient(activity: AppCompatActivity): GoogleSignInClient {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
            return GoogleSignIn.getClient(activity, gso)
        }

    }

}