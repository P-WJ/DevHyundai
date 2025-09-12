package com.example.springBootTDD.dto;

import com.example.springBootTDD.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 응답 DTO
@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}
