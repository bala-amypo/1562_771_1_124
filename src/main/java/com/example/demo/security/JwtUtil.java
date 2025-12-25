package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private final String secret = "my-secret-key-my-secret-key";
    private final long expirationMs = 3600000;

    // REQUIRED BY TESTS
    public JwtUtil() {
    }

    // REQUIRED BY TESTS
    public JwtUtil(byte[] secretBytes, long expirationMs) {
        this.expirationMs = expirationMs;
    }

    // REQUIRED BY CONTROLLER
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // REQUIRED BY FILTER
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // REQUIRED BY TESTS
    public boolean validateToken(String token) {
        return isTokenValid(token);
    }

    public String extractUsername(String token) {
        return extractEmail(token);
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).get("email", String.class);
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        Object id = extractAllClaims(token).get("userId");
        return id == null ? null : Long.valueOf(id.toString());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
