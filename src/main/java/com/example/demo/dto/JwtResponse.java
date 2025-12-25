mkdir -p src/main/java/com/example/demo/dto

cat <<'EOF' > src/main/java/com/example/demo/dto/JwtResponse.java
package com.example.demo.dto;

public class JwtResponse {

    private Long userId;
    private String email;
    private String role;
    private String token;

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse(String email, String role, Long userId, String token) {
        this.email = email;
        this.role = role;
        this.userId = userId;
        this.token = token;
    }

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
EOF
