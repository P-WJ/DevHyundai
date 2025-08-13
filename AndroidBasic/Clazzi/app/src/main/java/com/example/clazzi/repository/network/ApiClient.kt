package com.example.clazzi.repository.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue
import kotlin.jvm.java

object ApiClient {
    private const val BASE_URL = "https://timudyyvahvgwbdzyrym.supabase.co/rest/v1/"
    private const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRpbXVkeXl2YWh2Z3diZHp5cnltIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTQ5MTkxMTQsImV4cCI6MjA3MDQ5NTExNH0.p9EuuvXVSenHLxqt1TJoFNu9jTLkUgdhSGlhIwoot3s"

    private val authInterceptor = Interceptor{ chain ->
        val request = chain.request().newBuilder()
            .addHeader("apikey", API_KEY)
            .addHeader("Authorization", "Bearer $API_KEY")
            .addHeader("Content-Type", "application/json")
            .build()
        chain.proceed(request)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    val voteApiService: VoteApiService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VoteApiService::class.java)
    }
}