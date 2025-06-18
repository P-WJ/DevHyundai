package com.hd.sample_jpa_mysql_250605.entity;

import com.hd.sample_jpa_mysql_250605.constant.Authority;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(nullable = false)
    private String pwd;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 255)
    private String image;

    private LocalDateTime regDate;

    @PrePersist // DB에 INSERT 되기 전에 실행되는 메서드
    private void prePersist() {
        this.regDate = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    private Authority authority;


    @Builder
    public Member(String name, String pwd, String email, String image, Authority authority) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.image = image;
        this.authority = authority;
        this.regDate = LocalDateTime.now();
    }

}