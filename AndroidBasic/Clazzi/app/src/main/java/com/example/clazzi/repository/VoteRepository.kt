package com.example.clazzi.repository

import android.content.Context
import android.net.Uri
import com.example.clazzi.model.Vote
import kotlinx.coroutines.flow.Flow

interface VoteRepository {
    fun observeVotes(): Flow<List<Vote>>
    suspend fun addVote(vote: Vote, context: Context, imageUri : Uri)
    suspend fun setVote(vote: Vote)

    fun observeVoteById(voteId: String): Flow<Vote?>
}