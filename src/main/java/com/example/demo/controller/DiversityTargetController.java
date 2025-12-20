package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diversity-targets")
public class DiversityTargetController {

    private final DiversityTargetService service;

    public DiversityTargetController(DiversityTargetService service) {
        this.service = service;
    }

    // ✅ TEST ENDPOINT (REMOVES 404)
    @GetMapping("/test")
    public String test() {
        return "Diversity Target API is working!";
    }

    // ✅ CREATE TARGET
    @PostMapping
    public DiversityTarget create(@RequestBody DiversityTarget target) {
        return service.createTarget(target);
    }

    // ✅ GET ALL TARGETS
    @GetMapping
    public List<DiversityTarget> getAll() {
        return service.getAllTargets();
    }

    // ✅ GET BY YEAR
    @GetMapping("/year/{year}")
    public List<DiversityTarget> getByYear(@PathVariable Integer year) {
        return service.getTargetsByYear(year);
    }

    // ✅ DEACTIVATE TARGET
    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivateTarget(id);
        return "Target deactivated successfully";
    }
}
