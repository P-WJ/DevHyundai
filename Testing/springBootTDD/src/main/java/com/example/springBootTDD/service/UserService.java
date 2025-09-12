package com.example.springBootTDD.service;

import com.example.springBootTDD.dto.UserRequestDto;
import com.example.springBootTDD.dto.UserResponseDto;
import com.example.springBootTDD.entity.User;
import com.example.springBootTDD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// UserService 수정
// User 단순 반환에서 레포지토리 호출 반환
// Dto로 수정

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User(
                requestDto.getUsername(), requestDto.getPassword()
        );
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
