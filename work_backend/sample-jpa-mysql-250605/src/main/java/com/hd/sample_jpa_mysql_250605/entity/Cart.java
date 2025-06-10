package com.hd.sample_jpa_mysql_250605.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter @Setter @ToString
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 128, nullable = false)
    private String cartName;

    @OneToOne // 회원 엔티티와 일대일 매핑
    @JoinColumn(name="member_id")
    private Member member; // 생성된 회원 객체가 와야 함
}
