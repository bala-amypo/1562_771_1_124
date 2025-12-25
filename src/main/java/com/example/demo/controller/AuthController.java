package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userAccountService, JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public JwtResponse register(@RequestBody RegisterRequest request) {

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

        return new JwtResponse(
                saved.getEmail(),
                saved.getRole(),
                saved.getId(),
                token
        );
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        UserAccount user = userAccountService.findByEmailOrThrow(request.getEmail());

        if (!userAccountService.passwordMatches(
                request.getPassword(),
                user.getPassword())) {
            throw new RuntimeException("Unauthorized");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new JwtResponse(
                user.getEmail(),
                user.getRole(),
                user.getId(),
                token
        );
    }
}
