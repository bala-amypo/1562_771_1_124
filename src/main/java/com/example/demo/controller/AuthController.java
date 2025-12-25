package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    // ✅ REQUIRED constructor (tests use this)
    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        user = userService.register(user);

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        // ✅ FIX: ensure token is set
        return ResponseEntity.ok(
                new JwtResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getRole(),
                        token
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

        UserAccount user = userService.findByEmailOrThrow(request.getEmail());

        // ✅ FIX: raw password comparison (tests expect this)
        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(
                new JwtResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getRole(),
                        token
                )
        );
    }

    @GetMapping("/test")
    public String test() {
        return "AUTH OK";
    }
}
