package com.hd.sample_jpa_mysql_250605.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString @NoArgsConstructor
public class BoardResDto {
    private Long boardId;   // 게시글 번호, 댓글 작성 시 필요
    private String email;   // 작성자, 이름을 보여줘야 한다면 연관관계 매핑을 이용해 가져오면 됨
    private String title;
    private String content;
    private String img;
    private LocalDateTime createTime;
}
