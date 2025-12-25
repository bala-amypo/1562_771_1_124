package com.example.demo.dto;

public class JwtResponse {

    private Long userId;
    private String email;
    private String role;
    private String token;

    // ✅ No-args constructor (needed by Jackson/tests)
    public JwtResponse() {
    }

    // ✅ Token-only constructor (used by older code/tests)
    public JwtResponse(String token) {
        this.token = token;
    }

    // ✅ REQUIRED constructor (used by AuthController + tests)
   public JwtResponse(String email, String role, Long userId, String token) {
    this.userId = userId;
    this.email = email;
    this.role = role;
    this.token = token;
}

    // ===== GETTERS & SETTERS =====

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
