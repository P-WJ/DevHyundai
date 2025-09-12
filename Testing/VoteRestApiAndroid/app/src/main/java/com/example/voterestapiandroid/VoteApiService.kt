package com.example.voterestapiandroid

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface VoteApiService {
    @GET("votes")
    suspend fun getVotes(): List<Vote>

//    @POST("votes")
//    suspend fun createVote(@Body vote: Vote): Vote

    @Multipart
    @POST("votes")
    suspend fun createVote(
        @Part("vote") vote: RequestBody,
        @Part image: MultipartBody.Part?
    ): Vote

    @GET("votes/{id}")
    suspend fun getVote(@Path("id") id: Int): Vote

    @PUT("votes/{id}")
    suspend fun updateVote(@Path("id") id: Int, @Body vote: Vote): Vote

    @DELETE("votes/{id}")
    suspend fun deleteVote(@Path("id") id: Int)
}
