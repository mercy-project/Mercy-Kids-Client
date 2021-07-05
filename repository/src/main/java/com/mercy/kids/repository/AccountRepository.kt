package com.mercy.kids.repository

interface AccountRepository {

    val googleSignInUrl: String

    suspend fun signUp()

    suspend fun signIn()

    suspend fun activateUser()

}