package com.example.springBootTDD.repository;

import com.example.springBootTDD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA 레포지토리 생성
public interface UserRepository extends JpaRepository<User, Long> {
}
