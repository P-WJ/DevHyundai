package com.example.clazzi.model

import java.util.Date

data class Vote(
    val id: String = "",
    val title: String = "",
    val createAt: Date? = null,  // 투표 생성 날짜
    val voteOptions: List<VoteOption> = emptyList()
) {
    val optionCount: Int  // 투표 세부 항목 개수
        get() = voteOptions.size
}

data class VoteOption(
    val id: String = "",
    val optionText: String = "",
    val voters: List<String> = emptyList()  // 각 투표의 투표자 ID 저장
) {
    val voteCount: Int
        get() = voters.size
}