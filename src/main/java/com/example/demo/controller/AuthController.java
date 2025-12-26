package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserAccountService userAccountService;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    // ✅ REQUIRED FOR SPRING
    public AuthController() {
    }

    // ✅ REQUIRED FOR TESTS
    public AuthController(UserAccountService userAccountService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.authenticationManager = authenticationManager;
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
                token,
                saved.getEmail(),
                saved.getRole(),
                saved.getId()
        );
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        UserAccount user = userAccountService.findByEmailOrThrow(request.getEmail());

        if (!userAccountService.matchesPassword(
                request.getPassword(),
                user.getPassword())) {
            throw new AccessDeniedException("Unauthorized");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new JwtResponse(
                token,
                user.getEmail(),
                user.getRole(),
                user.getId()
        );
    }
}
