package com.hd.sample_jpa_mysql_250605.dto;


import com.hd.sample_jpa_mysql_250605.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResDto {
    private String email;
    private String name;
    private String image;
    private LocalDateTime regDate;

    public static MemberResDto of(Member member) {
        return MemberResDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .image(member.getImage())
                .regDate(member.getRegDate())
                .build();
    }
}
