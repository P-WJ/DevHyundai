package com.example.voterestapiandroid

import java.util.UUID

data class Vote(
    val id: Int? = null ,
    val title: String,
    val description: String,
)