package com.mercy.kids.client.di.account

import androidx.fragment.app.FragmentActivity
import com.mercy.kids.client.account.fragment.FindAccountPagerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AccountComponentModule {

    @Provides
    fun provideAccountPagerAdapter(activity: FragmentActivity) = FindAccountPagerAdapter(activity)

}