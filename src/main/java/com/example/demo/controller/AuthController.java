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
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // ✅ REQUIRED BY TESTS
    public AuthController(
            UserAccountService userAccountService,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.userAccountService = userAccountService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(
            @RequestBody RegisterRequest request
    ) {

        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        UserAccount saved = userAccountService.register(user);

        String token = jwtUtil.generateToken(
                saved.getId(),
                saved.getEmail(),
                saved.getRole()
        );

        JwtResponse response = new JwtResponse(
                saved.getEmail(),
                saved.getRole(),
                saved.getId(),
                token
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @RequestBody LoginRequest request
    ) {

        UserAccount user =
                userAccountService.findByEmailOrThrow(request.getEmail());

        if (!userAccountService.passwordMatches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException("Unauthorized");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        JwtResponse response = new JwtResponse(
                user.getEmail(),
                user.getRole(),
                user.getId(),
                token
        );

        return ResponseEntity.ok(response);
    }
}
