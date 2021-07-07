package com.mercy.kids.repository.account

interface AccountRepository {

    val googleSignInUrl: String

    suspend fun signUp()

    suspend fun signIn()

    suspend fun activateUser()

}