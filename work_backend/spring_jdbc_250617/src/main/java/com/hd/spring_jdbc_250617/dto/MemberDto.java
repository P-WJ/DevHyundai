package com.hd.spring_jdbc_250617.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String email;
    private String password;
    private String name;
    private LocalDateTime reg_date;
}
