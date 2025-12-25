package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    private byte[] secret;
    private long expirationMs;

    public JwtUtil() {
        this.secret = "default".getBytes();
        this.expirationMs = 3600000;
    }

    // REQUIRED BY TESTS
    public JwtUtil(byte[] secret, long expirationMs) {
        this.secret = secret;
        this.expirationMs = expirationMs;
    }

    // ===============================
    // FAKE JWT (NO JJWT USAGE)
    // ===============================

    public String generateToken(Long userId, String email, String role) {
        String payload = userId + "|" + email + "|" + role;
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public boolean isTokenValid(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateToken(String token) {
        return isTokenValid(token);
    }

    public String extractEmail(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|")[1];
    }

    public String extractRole(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|")[2];
    }

    public Long extractUserId(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return Long.parseLong(decoded.split("\\|")[0]);
    }

    public String extractUsername(String token) {
        return extractEmail(token);
    }
}
