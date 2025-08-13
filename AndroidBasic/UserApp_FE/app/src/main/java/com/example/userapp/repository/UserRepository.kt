package com.example.userapp.repository

import com.example.userapp.model.Product
import com.example.userapp.model.User
import com.example.userapp.network.RetrofitInstance

class UserRepository {
    private val api = RetrofitInstance.api

    suspend fun getUsers(): List<User> {
        return api.getUsers()
    }

    suspend fun getUser(id: Long): User {
        val user = api.getUser(id)
        val products = api.getUserProducts(id)
        return user.copy(products = products)
    }

    suspend fun createUser(user: User): User {
        return api.createUser(user)
    }

    suspend fun updateUser(id: Long, user: User): User {
        return api.updateUser(id, user)
    }

    suspend fun deleteUser(id: Long) {
        api.deleteUser(id)
    }

    suspend fun getUserProducts(id: Long): List<Product> {
        return api.getUserProducts(id)
    }


}