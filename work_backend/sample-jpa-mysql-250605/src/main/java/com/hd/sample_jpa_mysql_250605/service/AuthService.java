package com.hd.sample_jpa_mysql_250605.service;

import com.hd.sample_jpa_mysql_250605.dto.MemberReqDto;
import com.hd.sample_jpa_mysql_250605.dto.MemberResDto;
import com.hd.sample_jpa_mysql_250605.dto.SignUpReqDto;
import com.hd.sample_jpa_mysql_250605.dto.TokenDto;
import com.hd.sample_jpa_mysql_250605.entity.Member;
import com.hd.sample_jpa_mysql_250605.jwt.TokenProvider;
import com.hd.sample_jpa_mysql_250605.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j  // Log 정보를 출력하기 위한 롬복의 어노테이션
@Service    // Spring Container에 Bean 등록
@Transactional  // 여러개의 물리적 작업 단위를 논리적 단위로 묶음
@RequiredArgsConstructor    // 생성자를 자동 생성
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder; // 인증을 담당하는 클래스
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    // 회원 가입
    public MemberResDto signup(MemberReqDto requestDto) {
        if (memberRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Member member = requestDto.toEntity(passwordEncoder);
        return MemberResDto.of(memberRepository.save(member));
    }

    // 로그인
    public TokenDto login(MemberReqDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        return tokenProvider.generateTokenDto(authentication);
    }
}

