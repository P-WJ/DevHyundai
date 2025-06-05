package com.hd.sample_jpa_mysql_250605.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

// @Data // 모든 어노테이션을 한번에 적용
//
public class LoginReqDto {
    private String email;
    private String pwd;
}
