package com.hd.sample_jpa_mysql_250605.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// 게시글 쓰기
@Getter @Setter @ToString @NoArgsConstructor
public class BoardWriteDto {
    private String email;   // 작성자
    private String title;   // 글 제목
    private String content; // 글 내용
    private String img;     // 이미지 첨부

}
