package com.example.shoaib.domytask.controller;


import com.example.shoaib.domytask.configuration.SecurityConfig;
import com.example.shoaib.domytask.model.User;
import com.example.shoaib.domytask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final SecurityConfig securityConfig;

    @Autowired
    public UserController(UserService userService, SecurityConfig securityConfig) {
        this.userService = userService;
        this.securityConfig = securityConfig;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {

        User newUser = userService.registerUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmail(email);
        if (user != null && securityConfig.passwordEncoder().matches(password, user.getPassword())) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}