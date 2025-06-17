package com.hd.spring_jdbc_250617.controller;

import com.hd.spring_jdbc_250617.dto.MemberDto;
import com.hd.spring_jdbc_250617.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 전체 회원 조회
    @GetMapping
    public ResponseEntity<List<MemberDto>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    // 이메일로 회원 조회
    @GetMapping("/{email}")
    public ResponseEntity<MemberDto> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.findByEmail(email));
    }

    // 회원 등록
    @PostMapping("/signup")
    public ResponseEntity<Boolean> insert(@RequestBody MemberDto memberDto) {

    return ResponseEntity.ok(memberService.insert(memberDto));
    }

    // 회원 수정
    @PostMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody MemberDto memberDto) {
       return ResponseEntity.ok(memberService.update(memberDto));
    }


    // 회원 삭제
    @DeleteMapping("/{email}")
    public ResponseEntity<Boolean> delete(@PathVariable String email) {
        return ResponseEntity.ok(memberService.delete(email));
    }

}
