package com.example.springsecurityjwt.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TokenDTO {
    private final String jwt;
}
