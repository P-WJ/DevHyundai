package com.example.userIntegration.repository;

import com.example.userIntegration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username); // username으로 존재 여부 확인

    // 중복 username 체크 (다른 ID에)
    boolean existsByUsernameAndIdNot(String username, Long id);
}