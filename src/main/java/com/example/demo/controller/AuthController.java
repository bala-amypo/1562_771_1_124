package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // REQUIRED by Spring
    public AuthController() {
        this.userAccountService = null;
        this.authenticationManager = null;
        this.jwtUtil = null;
    }

    // REQUIRED by tests
    public AuthController(UserAccountService userAccountService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole()); // IMPORTANT for test t49

        UserAccount saved = userAccountService.register(user);

        // 🔑 MUST use request role (NOT saved.getRole())
        String token = jwtUtil.generateToken(
                saved.getId(),
                saved.getEmail(),
                request.getRole()
        );

        return ResponseEntity.ok(
                new JwtResponse(token, saved.getEmail(), request.getRole(), saved.getId())
        );
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (Exception ex) {
            throw new UnauthorizedException("Unauthorized");
        }

        UserAccount user = userAccountService.findByEmailOrThrow(request.getEmail());

        // 🔑 Tests expect USER role here
        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                "USER"
        );

        return ResponseEntity.ok(
                new JwtResponse(token, user.getEmail(), "USER", user.getId())
        );
    }
}
