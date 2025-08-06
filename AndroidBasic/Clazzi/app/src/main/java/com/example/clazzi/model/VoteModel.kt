package com.example.clazzi.model

data class Vote(
    val id: String,
    val title: String,
    val voteOptions: List<VoteOption>
){

}

data class VoteOption(
    // tmdb 영화 id
    val id: String,
    val optionText : String,
)