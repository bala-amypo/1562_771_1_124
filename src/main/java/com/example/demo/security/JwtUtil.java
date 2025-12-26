package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    private byte[] secret;
    private long expiration;

    // REQUIRED by Spring
    public JwtUtil() {
        this.secret = "default-secret".getBytes();
        this.expiration = 3600000;
    }

    // REQUIRED by tests
    public JwtUtil(byte[] secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(Long userId, String email, String role) {
        String payload = email + "|" + role + "|" + userId;
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public String extractEmail(String token) {
        return decode(token)[0];
    }

    public String extractRole(String token) {
        return decode(token)[1];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(decode(token)[2]);
    }

    public boolean validateToken(String token) {
        try {
            decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String[] decode(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|");
    }
}
