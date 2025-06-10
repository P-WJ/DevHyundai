package com.hd.sample_jpa_mysql_250605.repository;

import com.hd.sample_jpa_mysql_250605.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
