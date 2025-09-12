package com.example.springBootTDD.controller;

// 이번엔 createUser()만 컨트롤러 레이어에서 테스트 합니다.

import com.example.springBootTDD.dto.UserRequestDto;
import com.example.springBootTDD.dto.UserResponseDto;
import com.example.springBootTDD.entity.User;
import com.example.springBootTDD.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 웹 요청만 흉내 내서(UserController만 로드) 컨트롤러만 테스트
// 웹 계층만 띄워서 UserController만 테스트
// 실제 서버를 띄우진 않습니다. 컨트롤러 관련 빈만 로드.
@WebMvcTest(UserController.class)
public class UserControllerTest {

    // 가짜 HTTP 요청을 만들어 컨트롤러에 호출한다.
    // 응답(상태코드/본문)을 검사하게 해주는 테스트 도구
    // 실제 서버를 띄우지 않고도 웹 계층에서 컨트롤러를 호출하는 도구
    @Autowired
    MockMvc mockMvc;

    // @WebMvcTest를 통해 컨트롤러 계층만 띄워서 테스트하고 있기 때문에
    //  UserService 목 주입해준다.
    // 컨트롤러 테스트는 DB 테스트는 하지 않기 때문에 목킹 한다.
    @MockitoBean
    private UserService userService;

    // 객체를 제이슨으로 변환해주는 도구
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        reset(userService); // userService 목에 스텁된 설정을 초기화 해준다.
    }

    @Test
    void performPostUsers() throws Exception { // 체크드 익셉션: perform()에서 익셉션 던지기 때문에
        // 1. 레드 단계: 실제 UserController 없음
        // 2. 그린 단계: UserController 만들기만 한다.

        /// given
        // UserRequestDto를 objectMapper로 제이슨으로 변환 가능
        // 호출용
        UserRequestDto requestDto = new UserRequestDto("조기환", "1234");
        // 결과 확인용
        UserResponseDto responseDto = new UserResponseDto(new User("조기환", "1234"));

        // userService 스터빙 해준다. (1.레드: 스터빙 없이 테스트, 2.그린: 스터빙 후 테스트)
        when(userService.createUser(any(UserRequestDto.class))).thenReturn(responseDto);

        /// when & then
        // 레드 단계: mockMvc으로 컨트롤러 실제 api를 호출한다.
        // 하지만 UserController에는 아무 것도 만들어져 있지 않다.
        // 포스트로 /user(유저 생성) 호출한다.
        // 아직은 검증(매처스) 없기 때문에 에러는 없음.
        mockMvc.perform(
                        post("/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        // raw 제이슨 요청 데이타
                                        "{\"username\":\"조기환\",\"password\":\"1234\"}"
                                )
                                // objectMapper로도 가능
//                                .content(objectMapper.writeValueAsString(requestDto))
                )
                // 검증(매처스) : assertEquals()랑 같은 역할
                // 레드 단계: 아직 컨트롤러 api도 없고, 응답코드도 없기 때문(없기 때문에 지금은 404 not found)
                // 그린 단계: 스켈레톤으로 해당 api만 구현 한다. 추가로 응답 코드 201로 설정
                // 리팩토링 단계: api 구현한다.(컨트롤러 구현)
                .andExpect(status().isCreated()) // status 임포트: result.MockMvcResultMatchers
                // 저장되어 반환되는 User 검증
                .andExpect(jsonPath("$.username").value("조기환"));
//                .andExpect(jsonPath("$.password").value("1234"));

    }

    @Test
    void getAllUser() throws Exception {
        UserResponseDto user = new UserResponseDto(new User("조기환", "1234"));
        List<UserResponseDto> users = List.of(user);
        when(userService.getAllUsers()).thenReturn(users);

        // 레드: api 없음
        // 그린 & 리팩토링 : 컨트롤러 api 생성
        mockMvc.perform(
                get("/users")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].username").value("조기환"));
    }
}









