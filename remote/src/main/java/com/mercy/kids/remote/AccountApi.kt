package com.mercy.kids.remote

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AccountApi {

    companion object {
        private const val ENDPOINT = "/auth"
    }

    @FormUrlEncoded
    @POST("$ENDPOINT/signup")
    suspend fun signUp(
        @Field("email" )email: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("phoneNumber") phoneNumber: String
    ): Response<String>

    @FormUrlEncoded
    @POST("$ENDPOINT/signin")
    fun signIn(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<String>

}