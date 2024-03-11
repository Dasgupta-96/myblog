package com.myblog.myblog11.repository;

import com.myblog.myblog11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
