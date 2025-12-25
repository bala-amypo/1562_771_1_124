package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // ✅ EXACT constructor expected by tests
    public AuthController(
            UserAccountService userAccountService,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.userAccountService = userAccountService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // =========================
    // REGISTER
    // =========================
    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        UserAccount saved = userAccountService.register(user);

        String token = jwtUtil.generateToken(
                saved.getEmail(),
                saved.getRole(),
                saved.getId()
        );

        // ✅ ORDER MATCHES TEST: (email, role, userId, token)
        return ResponseEntity.ok(
                new JwtResponse(
                        saved.getEmail(),
                        saved.getRole(),
                        saved.getId(),
                        token
                )
        );
    }

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

        UserAccount user =
                userAccountService.findByEmailOrThrow(request.getEmail());

        if (!userAccountService.passwordMatches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole(),
                user.getId()
        );

        // ✅ ORDER MATCHES TEST
        return ResponseEntity.ok(
                new JwtResponse(
                        user.getEmail(),
                        user.getRole(),
                        user.getId(),
                        token
                )
        );
    }
}
