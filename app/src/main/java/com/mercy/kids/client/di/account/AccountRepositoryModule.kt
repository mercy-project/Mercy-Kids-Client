package com.mercy.kids.client.di.account

import com.mercy.kids.remote.AccountApi
import com.mercy.kids.repository.AccountRepository
import com.mercy.kids.repository.AccountRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AccountRepositoryModule {

    @Binds
    abstract fun bindAccountRepository(impl: AccountRepositoryImpl): AccountRepository

}

@Module
@InstallIn(ActivityRetainedComponent::class)
object AccountApiModule {

    @Provides
    fun provideAccountApi(retrofit: Retrofit): AccountApi = retrofit.create(AccountApi::class.java)

}