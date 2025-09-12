package com.example.springBootTDD;

import com.example.springBootTDD.dto.UserRequestDto;
import com.example.springBootTDD.dto.UserResponseDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 여기까지 서비스, 컨트롤러 CRUD TDD로 완료했다 가정하고
// 통합 테스트까지 TDD 확장
// - 실제로 서버 띄워서 api 호출 해본다.
// 통합 테스트 하기전에 추가 하면 좋은 내용
// - 쿼리메소드 테스트

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class SpringBootTddApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void createAndFindAllUsers_success() {
		// Given: 유저 생성
		UserRequestDto requestDto = new UserRequestDto("조기환", "1234");
		HttpEntity<UserRequestDto> request = new HttpEntity<>(requestDto);

		// When: POST /users
		ResponseEntity<UserResponseDto> createResponse = restTemplate.exchange(
				"/users", HttpMethod.POST, request, UserResponseDto.class);

		// Then: 생성 확인
		assertEquals(HttpStatus.CREATED, createResponse.getStatusCode());
		assertEquals("조기환", createResponse.getBody().getUsername());

		// When: GET /users
		ResponseEntity<UserResponseDto[]> findAllResponse = restTemplate.getForEntity(
				"/users", UserResponseDto[].class);

		// Then: 전체 조회 확인
		assertEquals(HttpStatus.OK, findAllResponse.getStatusCode());
		assertEquals(1, findAllResponse.getBody().length);
		assertEquals("조기환", findAllResponse.getBody()[0].getUsername());
	}

}
