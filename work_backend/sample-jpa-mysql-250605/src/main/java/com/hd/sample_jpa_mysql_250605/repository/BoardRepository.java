package com.hd.sample_jpa_mysql_250605.repository;

import com.hd.sample_jpa_mysql_250605.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // 제목이 포함된 게시글 찾기 (LIKE 검색)
    List<Board> findByTitleContaining(String title);
    // email로 게시글 찾기
    List<Board> findByMemberEmail(String email);
    // 페이지네이션
    Page<Board> findAll(Pageable pageable);

}
