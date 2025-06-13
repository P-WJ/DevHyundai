package com.hd.sample_jpa_mysql_250605.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Getter @Setter @ToString @NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // board_id

    @Column(length = 256, nullable = false)
    private String title;   // 게시글 제목

    @Lob // 대용량 텍스트
    private String content; // 게시글 내용
    private String image;   // 게시글 첨부될 이미지의 주소
    private LocalDateTime createTime;
    @PrePersist
    public void prePersist() {
        this.createTime = LocalDateTime.now();  // DB에 쓰기 직전에 시간 포함
    }

    @ManyToOne(fetch = FetchType.LAZY)  // board가 사용될때 join됨
    @JoinColumn(name="member_id")
    private Member member;  // 회원정보 객체 가져오기
    

    }
