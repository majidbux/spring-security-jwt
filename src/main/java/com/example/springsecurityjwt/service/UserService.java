package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.dto.UserDTO;
import com.example.springsecurityjwt.exception.NotFoundException;
import com.example.springsecurityjwt.repository.UserRepository;
import com.example.springsecurityjwt.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new NotFoundException(String.format("User with username [{}] not found", userName)));
    }

    public UserDTO getUser(@NotNull final Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id [{}] not found", userId)));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        userDTO.setUserName(user.getUsername());
        return userDTO;
    }
}