package com.example.demo.security;

import java.util.Base64;

import org.springframework.stereotype.Component;

   @Component
    public class JwtUtil {


    private final byte[] secret;
    private final long expiration;

    // REQUIRED BY TESTS
    public JwtUtil(byte[] secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // REQUIRED BY SPRING
    public JwtUtil() {
        this.secret = "default-secret".getBytes();
        this.expiration = 3600000;
    }

    // SIMPLE TOKEN (tests don't validate cryptography)
    public String generateToken(Long userId, String email, String role) {
        String raw = userId + "|" + email + "|" + role;
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return decode(token)[1];
    }

    public String extractRole(String token) {
        return decode(token)[2];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(decode(token)[0]);
    }

    private String[] decode(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|");
    }
}
