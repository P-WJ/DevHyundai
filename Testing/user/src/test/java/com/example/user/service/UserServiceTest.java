package com.example.user.service;

import com.example.user.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 실제 스프링 부트 통합 테스트
//@Transactional // 각 테스트가 끝나면 DB 롤백
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void saveAndFindUser() {
        // given
        User user = new User();
        user.setName("우하하");
        user.setAge(20);

        // when
        User saveUser = userService.save(user);

        // then
        Optional<User> found = userService.findById(saveUser.getId());
        assertEquals("우하하", found.get().getName());
        assertEquals(20, found.get().getAge());

        /// fluent 방식: 말하는 거 같은 방식
//        assertThat(found).isPresent();
//        assertThat(found).isEmpty();



    }

    @BeforeEach
    void setUp() {
        userService.deleteAllUsers();
    }
    @Test
    void findAllUsers() {
        // given
        User user1 = new User();
        user1.setName("박하하");
        user1.setAge(26);

        User user2 = new User();
        user2.setName("우하하");
        user2.setAge(20);

        userService.save(user1);
        userService.save(user2);

        // when
        List<User> users = userService.findAll();

        // then
        assertThat(users).hasSize(2);
    }
}