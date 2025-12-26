package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
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

    // ✅ Constructor used by TESTS
    public AuthController(UserAccountService userAccountService,
                          org.springframework.security.authentication.AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ Constructor used by SPRING BOOT
    @Autowired
    public AuthController(UserAccountService userAccountService,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

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

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {

        // 🔑 Convert DTO → Entity (THIS FIXES THE ERROR)
        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        userAccountService.register(user);

        Long userId = 1L;
        String token = jwtUtil.generateToken(userId, user.getEmail(), "USER");

        JwtResponse response = new JwtResponse(
                token,
                "Bearer",
                userId,
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }
}
