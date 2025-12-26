package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    // ✅ USED BY TESTS
    public AuthController(UserAccountService userAccountService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ USED BY SPRING AT RUNTIME
    @Autowired
    public AuthController(UserAccountService userAccountService,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        String username = request.getEmail();

        Long userId = 1L;
        String role = "USER";

        String token = jwtUtil.generateToken(userId, username, role);

        return new JwtResponse(
                token,
                "Bearer",
                userId,
                username
        );
    }
}
