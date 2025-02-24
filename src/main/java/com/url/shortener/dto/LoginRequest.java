package com.url.shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
