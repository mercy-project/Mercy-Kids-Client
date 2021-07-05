package com.mercy.kids.client.di.account

import android.app.Activity
import com.mercy.kids.client.account.activity.FindAccountActivity
import com.mercy.kids.client.account.activity.LoginHomeActivity
import com.mercy.kids.client.account.activity.SignUpActivity
import com.mercy.kids.client.account.usecase.FindAccountUseCase
import com.mercy.kids.client.account.usecase.LoginHomeUseCase
import com.mercy.kids.client.account.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AccountUseCaseModule {

    @Provides
    fun provideFindAccountActivityUseCase(activity: Activity): FindAccountUseCase {
        return if(activity is FindAccountActivity) {
            FindAccountUseCase(activity)
        } else throw ClassCastException("wrong activity")
    }

    @Provides
    fun provideLoginHomeActivityUseCase(activity: Activity): LoginHomeUseCase {
        return if(activity is LoginHomeActivity) {
            LoginHomeUseCase(activity)
        } else throw ClassCastException("wrong activity")
    }

    @Provides
    fun provideSignUpUseCase(activity: Activity): SignUpUseCase {
        return if(activity is SignUpActivity) {
            SignUpUseCase(activity)
        } else throw ClassCastException("wrong activity")
    }

}