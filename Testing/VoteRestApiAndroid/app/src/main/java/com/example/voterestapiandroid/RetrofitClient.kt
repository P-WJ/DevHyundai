package com.example.voterestapiandroid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080/" // 애뮬레이터에서 로컬호스트 호출 할 때 주소

    val voteApiService: VoteApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VoteApiService::class.java)
    }
}