package com.example.voteRestApi.repository;

import com.example.voteRestApi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}