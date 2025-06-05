package com.hd.sample_jpa_mysql_250605.controller;

import com.hd.sample_jpa_mysql_250605.dto.LoginReqDto;
import com.hd.sample_jpa_mysql_250605.dto.MemberRegDto;
import com.hd.sample_jpa_mysql_250605.dto.MemberResDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.loader.plan.exec.internal.AliasResolutionContextImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j // Log 메시지 출력을 위한 어노테이션
@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberRegDto memberRegDto) {
        log.info("member : {}", memberRegDto);
        MemberResDto memberResDto = new MemberResDto();
        memberResDto.setEmail(memberRegDto.getEmail());
        memberResDto.setName(memberRegDto.getName());
        memberResDto.setPwd(memberRegDto.getPwd());
        memberResDto.setImage("/test/test.img");
        memberResDto.setRegDate(LocalDateTime.now());
        return ResponseEntity.ok(memberResDto);
    }

    // 로그인 Controller
    // Post 방식 : email, pwd를 Request Body 형식으로 수신
    // 응답은 boolean 값으로 응답 (true / false)
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginReqDto loginReqDto) {
        log.info("login : {}", loginReqDto);
        return ResponseEntity.ok(true);
    }

    // 회원 조회 Controller
    // Get 방식 : email이 있으면 해당 회원 조회
    // 없으면 전체 회원 조회
    // 단, 회원 정보 리스트는 서비스로직과 DB 가 없으므로, for문으로 자체 생성

    private List<MemberResDto> generateMember() {
        List<MemberResDto> list = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            MemberResDto memberResDto = new MemberResDto();
            memberResDto.setEmail("jks2024" + i);
            memberResDto.setImage("/image/test.img" + i);
            memberResDto.setPwd("sphb8250" + i);
            memberResDto.setName("곰돌이" + i);
            memberResDto.setRegDate(LocalDateTime.now());
            list.add(memberResDto);
        }
        return list;
    }
    @GetMapping("/list")
    public ResponseEntity<?> getMember(@RequestParam(required = false) String email) {
        log.error("email : {}", email);
        List<MemberResDto> ls = generateMember();
        if (email == null || email.isBlank()) {
            return ResponseEntity.ok(ls);
        }
        for (MemberResDto memberResDto : ls) {
            if (memberResDto.getEmail().equals(email)) {
                return ResponseEntity.ok(memberResDto);
            }
        }
        return ResponseEntity.notFound().build(); // 404
    }

}