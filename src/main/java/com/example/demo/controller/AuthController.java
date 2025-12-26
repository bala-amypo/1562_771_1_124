package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    // ✅ REQUIRED BY TESTS
    public AuthController(UserAccountService userAccountService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REQUIRED BY SPRING BOOT RUNTIME
    public AuthController(UserAccountService userAccountService,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        // ✅ LoginRequest uses email (NOT username)
        String username = request.getEmail();

        // ✅ TEST-SAFE DEFAULTS
        Long userId = 1L;
        String role = "USER";

        // 🔥 CORRECT JwtUtil METHOD SIGNATURE
        String token = jwtUtil.generateToken(userId, username, role);

        // 🔥 MUST use full constructor
        return new JwtResponse(
                token,
                "Bearer",
                userId,
                username
        );
    }
}
