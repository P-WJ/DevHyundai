package com.hd.spring_jdbc_250617.service;

import com.hd.spring_jdbc_250617.dao.MemberDao;
import com.hd.spring_jdbc_250617.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberDao memberDao;

    // 회원 전체 조회
    public List<MemberDto> findAll() {
        return memberDao.findAll();
    }

    // 이메일로 회원 조회
    public MemberDto findByEmail(String email) {
        MemberDto result = memberDao.findByEmail(email);
        if (result == null) {
            throw new RuntimeException("해당 이메일이 존재하지 않습니다.");
        }
        return result;
    }

    // 회원 추가
    public boolean insert(MemberDto memberDto) {
        memberDto.setReg_date(LocalDateTime.now());
        return memberDao.insert(memberDto) > 0;
    }

    // 회원 정보 수정
    public boolean update(MemberDto memberDto) {
        return memberDao.update(memberDto) > 0;
    }

    //회원 정보 삭제
    public boolean delete(String email) {
        return memberDao.delete(email) > 0;
    }
}
