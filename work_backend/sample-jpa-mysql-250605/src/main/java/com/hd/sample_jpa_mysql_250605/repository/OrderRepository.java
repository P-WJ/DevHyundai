package com.hd.sample_jpa_mysql_250605.repository;

import com.hd.sample_jpa_mysql_250605.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
