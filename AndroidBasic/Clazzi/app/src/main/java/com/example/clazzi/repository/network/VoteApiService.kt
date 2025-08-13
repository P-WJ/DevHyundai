package com.example.clazzi.repository.network

import com.example.clazzi.model.Vote
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface VoteApiService {
    @GET("votes")
    suspend fun getVotes(): List<Map<String, Any?>>

    @POST("votes")
    suspend fun addVote(@Body vote : Map<String, @JvmSuppressWildcards Any?>)

    @PUT("votes/{voteId}")
    suspend fun updateVote(@Path("id") id:String ,@Body vote : Map<String, @JvmSuppressWildcards Any?>)

    @GET("votes")
    suspend fun getVoteById(@Query("id") id: String) : Response<List<Map<String, Any?>>>

}