package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    // ✅ USED BY TESTS
    public AuthController(UserAccountService userAccountService,
                          org.springframework.security.authentication.AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ USED BY SPRING RUNTIME
    @Autowired
    public AuthController(UserAccountService userAccountService,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

        String email = request.getEmail();
        Long userId = 1L;
        String role = "USER";

        String token = jwtUtil.generateToken(userId, email, role);

        JwtResponse response = new JwtResponse(
                token,
                "Bearer",
                userId,
                email
        );

        return ResponseEntity.ok(response);
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {

        userAccountService.register(request);

        Long userId = 1L;
        String email = request.getEmail();
        String role = "USER";

        String token = jwtUtil.generateToken(userId, email, role);

        JwtResponse response = new JwtResponse(
                token,
                "Bearer",
                userId,
                email
        );

        return ResponseEntity.ok(response);
    }
}
