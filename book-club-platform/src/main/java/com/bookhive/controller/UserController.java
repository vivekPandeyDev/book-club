package com.bookhive.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookhive.dto.user.UserResponseDto;
import com.bookhive.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAllUsers(Pageable pageable) {
        Page<UserResponseDto> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }
}

