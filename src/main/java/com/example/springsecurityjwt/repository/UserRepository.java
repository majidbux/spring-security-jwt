package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(final String userName);

    Optional<User> findById(final Long id);
}
