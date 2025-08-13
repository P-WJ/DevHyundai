package com.example.user.app;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, name = "user_id")
//    private Long userId;

    private String name;
}
