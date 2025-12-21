package com.example.demo.servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleStatusServlet {

    @GetMapping("/")
    public String status() {
        return "Supplier Diversity Tracker Backend is running";
    }
}
