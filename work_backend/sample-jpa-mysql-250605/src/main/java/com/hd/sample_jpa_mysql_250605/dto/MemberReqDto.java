package com.hd.sample_jpa_mysql_250605.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberReqDto {
    private String pwd;
    private String name;
    private String image;
    private String email;
}
