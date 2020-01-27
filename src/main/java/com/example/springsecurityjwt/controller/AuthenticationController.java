package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.dto.AuthenticationRequestDTO;
import com.example.springsecurityjwt.dto.TokenDTO;
import com.example.springsecurityjwt.exception.AuthenticationException;
import com.example.springsecurityjwt.service.UserService;
import com.example.springsecurityjwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userDetailsService;
    private final JwtUtil jwtUtils;

    @PostMapping("/authenticate")
    public TokenDTO authenticate(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUserName(), authenticationRequestDTO.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Invalid username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestDTO.getUserName());
        return new TokenDTO(jwtUtils.generateToken(userDetails));
    }
}
