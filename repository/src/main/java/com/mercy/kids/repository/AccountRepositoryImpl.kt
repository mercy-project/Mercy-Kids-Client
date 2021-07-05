package com.mercy.kids.repository

import com.mercy.kids.remote.AccountApi
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountApi: AccountApi
): AccountRepository {

    override val googleSignInUrl: String = ""

    override suspend fun signUp() {

    }

    override suspend fun signIn() {

    }

    override suspend fun activateUser() {

    }

}