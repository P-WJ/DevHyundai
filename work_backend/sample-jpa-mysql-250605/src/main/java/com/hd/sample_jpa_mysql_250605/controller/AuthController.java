package com.hd.sample_jpa_mysql_250605.controller;

import com.hd.sample_jpa_mysql_250605.dto.LoginReqDto;
import com.hd.sample_jpa_mysql_250605.dto.SignUpReqDto;
import com.hd.sample_jpa_mysql_250605.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j // Log 메시지 출력을 위한 어노테이션
@RestController // Rest API (GET, POST, PUT, DELETE)
@RequiredArgsConstructor    // 생성자를 통한 의존성 주입을 받기 위해서 생성자를 자동 생성
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    // 회원가입 여부 확인
    @GetMapping("exists/{email}")   // 정보가 브라우저 주소창에 보여짐
    public ResponseEntity<Boolean> existByEmail(@PathVariable String email) {
        boolean isExist = authService.isMember(email);
        return ResponseEntity.ok(!isExist);
    }


    // 회원가입
    @PostMapping("/signup") // Body에 정보를 싣는 방식, 정보가 보여지지 않음
    public ResponseEntity<Boolean> signup(@RequestBody SignUpReqDto memberReqDto) {
        boolean isSuccess = authService.signup(memberReqDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginReqDto loginReqDto) {
        boolean isSuccess = authService.login(loginReqDto.getEmail(), loginReqDto.getPwd());
        return ResponseEntity.ok(isSuccess);
    }
}