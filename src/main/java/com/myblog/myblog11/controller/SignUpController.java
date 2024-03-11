package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Role;
import com.myblog.myblog11.entity.User;
import com.myblog.myblog11.payload.SignUpDto;
import com.myblog.myblog11.repository.RoleRepository;
import com.myblog.myblog11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class SignUpController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    // http://localhost:8080/api/auth/signup
    public ResponseEntity<?> RegisterUser(@RequestBody SignUpDto signUpDto){

        if(userRepository.existsByEmail(signUpDto.getEmail())){

            return new ResponseEntity<>("Email already exists!!", HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByUsername(signUpDto.getUsername())){

            return new ResponseEntity<>("Username already exists!!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepository.findByName(signUpDto.getRollType()).get();

        Set<Role> convertRoleToSet = new HashSet<>();
        convertRoleToSet.add(roles);
user.setRoles(convertRoleToSet);

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully!!",HttpStatus.CREATED);
    }
}
