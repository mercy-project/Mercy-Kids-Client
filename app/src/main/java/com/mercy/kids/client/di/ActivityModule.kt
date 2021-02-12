package com.mercy.kids.client.di

import androidx.fragment.app.FragmentActivity
import com.mercy.kids.client.login.fragment.FindAccountPagerAdapter
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

    }

}