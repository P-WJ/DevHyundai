package com.hd.sample_jpa_mysql_250605.controller;

import com.hd.sample_jpa_mysql_250605.dto.MemberReqDto;
import com.hd.sample_jpa_mysql_250605.dto.MemberResDto;
import com.hd.sample_jpa_mysql_250605.dto.SignUpReqDto;
import com.hd.sample_jpa_mysql_250605.repository.MemberRepository;
import com.hd.sample_jpa_mysql_250605.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Log 메시지 출력을 위한 어노테이션
@RestController // Rest API (GET, POST, PUT, DELETE)
@RequiredArgsConstructor  // 생성자를 통한 의존성 주입을 받기 위해서 생성자를 자동 생성
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
public class MemberController {
    private final MemberService memberService;
    // 회원 전체 조회
    @GetMapping("/member-list")
    public ResponseEntity<List<MemberResDto>> findAll() {
        List<MemberResDto> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    // 회원 상세 조회
    @GetMapping("/member/{email}")
    public ResponseEntity<MemberResDto> findByEmail (@PathVariable String email) {
        MemberResDto member = memberService.findByEmail(email);
        return  ResponseEntity.ok(member);
    }


    // 회원 정보 수정
    @PostMapping("/member-modify")
    public ResponseEntity<Boolean> modifyNumber(@RequestBody MemberReqDto memberReqDto) {
        boolean isSuccess = memberService.modifyMember(memberReqDto);
        return  ResponseEntity.ok(isSuccess);

    }
    // 회원 삭제
    @DeleteMapping("/member-delete/{email}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable MemberReqDto email) {
        boolean isSuccess = memberService.deleteMember(email);
        return  ResponseEntity.ok(isSuccess);

    }

}
