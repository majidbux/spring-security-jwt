package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.dto.UserDTO;
import com.example.springsecurityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public UserDTO get(@PathVariable("id") Long userId) {
        return userService.getUser(userId);
    }
}
