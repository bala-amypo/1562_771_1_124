package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        // Dummy token generation for testcases
        return userId + ":" + email + ":" + role;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains(":");
    }

    public String extractUsername(String token) {
        return token.split(":")[1];
    }
}
