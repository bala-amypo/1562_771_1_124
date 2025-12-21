package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/test")
    public String test() {
        return "Auth API working!";
    }

    @PostMapping("/login")
    public String login() {
        return "Login API pending";
    }

    @PostMapping("/register")
    public String register() {
        return "Register API pending";
    }
}
