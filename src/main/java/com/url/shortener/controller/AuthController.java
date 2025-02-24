package com.url.shortener.controller;

import com.url.shortener.dto.LoginRequest;
import com.url.shortener.dto.RegisterRequest;
import com.url.shortener.jwt.JwtAuthenticationResponse;
import com.url.shortener.models.User;
import com.url.shortener.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @PostMapping("/public/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        JwtAuthenticationResponse a = userService.authenticateUser(loginRequest);
        return ResponseEntity.ok(a);
    }

    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setRole("ROLE_USER");
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
