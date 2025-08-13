package com.example.userapp.model

data class User(
    val id: Long? = null,
    val name: String,
    val email: String,
    val products: List<Product> = emptyList()
) {
}

data class Product(
    val id: Long? = null,
    val name: String
)