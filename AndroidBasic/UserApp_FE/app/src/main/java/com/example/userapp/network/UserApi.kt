package com.example.userapp.network

import com.example.userapp.model.Product
import com.example.userapp.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApi {
    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/users/{id}")
    suspend fun getUser(@Path("id") id : Long): User

    @POST("/users")
    suspend fun createUser(@Body user: User): User

    @PUT("/users/{id}")
    suspend fun updateUser(@Path("id") id : Long, @Body user:User) : User

    @DELETE("/users/{id}")
    suspend fun deleteUser(@Path("id") id : Long) : Response<Unit>

    @GET("/users/{id}/products")
    suspend fun getUserProducts(@Path("id") id : Long): List<Product>

}