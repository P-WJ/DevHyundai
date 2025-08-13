package com.example.clazzi.model

import java.util.Date

data class Vote(
    val id: String = "",
    val title: String = "",
    val createAt: Date? = null,
    val voteOptions: List<VoteOption> = emptyList<VoteOption>(),
    val imageUrl: String? = null,
    val deadline: Date? = null,
){
    val optionCount: Int // 투표 세부 항목 개 수
        get() = voteOptions.size
}

data class VoteOption(
    val id: String = "",
    val optionText : String = "",
    val voters: List<String> = emptyList(), // 각 투표의 투표자 Id 저장
){
    val voteCount: Int
        get() = voters.size
}