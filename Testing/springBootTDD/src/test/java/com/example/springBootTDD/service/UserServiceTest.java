package com.example.springBootTDD.service;

import com.example.springBootTDD.dto.UserRequestDto;
import com.example.springBootTDD.dto.UserResponseDto;
import com.example.springBootTDD.entity.User;
import com.example.springBootTDD.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 실무에서 보통 서비스 레이어(계층)부터 TDD를 합니다.
// - 컨트롤러 레이어부터 해도 상관없습니다. 팀의 상황에 따라 다르겠습니다.
// - 프론트엔트 팀과 먼저 협업이 중요한 경우에는 컨틀로러부터 하기도 합니다.

@SpringBootTest // 테스트 실행할 때 서버를 띄우기 위해
@Transactional // 테스트마다 디비 롤백
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 순서 지정 활성화
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    // 각 테스트 실행 전 디비 초기화
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Autowired
    private UserService userService;

    @Test
//    @Order(1) // 먼저 실행
    void createUser() {
        // 제일 기본적인 유저 생성부터 시작해봅니다.
        // 실무에서 사실 TDD는 개인의 보폭에 따라 다르기 때문에 정답은 없습니다.

        /// given
        // 유저 인스턴스 생성해봅니다.
        // dto로 수정
        UserRequestDto requestDto = new UserRequestDto("조기환", "1234"); // 레드 단계: 유저 엔티티 없음

        /// when
        // dto로 수정
        UserResponseDto responseDto = userService.createUser(requestDto); // 레드 단계: 유저 서비스 없기 때문에

        /// then
        // 이제 레포지토리에 연결해봅니다.
        // 레드 단계: 유저 단순 반환일 때는 id 생성되지 않기 때문에 검증 실패
        // 리팩토링 단계: userRepository.save(user)가 id까지 반환하므로 성공
        assertEquals(1, responseDto.getId());
        assertEquals("조기환", responseDto.getUsername());
//        assertEquals("1234", responseDto.getPassword());


    }

    // 서비스 레이어 유저 목록 조회 TDD
    @Test
//    @Order(2) // 나중에 실행
    void getAllUsers() {
        /// given
        UserRequestDto requestDto = new UserRequestDto("조기환", "1234");
        userService.createUser(requestDto);

        /// when
        // 1. 레드: userService.getAllUsers() 없음
        // 2. 그린: userService.getAllUsers() 스켈레톤 생성
        List<UserResponseDto> users = userService.getAllUsers();

        /// then
        // 1. 레드: 현재 userService.getAllUsers() 스켈레톤 코드로 되어있음
        // 2. 그린:
        assertEquals(1, users.size());
    }
}











