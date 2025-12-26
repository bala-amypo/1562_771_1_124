package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/targets")
public class DiversityTargetController {

    @Autowired
    private DiversityTargetService diversityTargetService;

    // ✅ REQUIRED FOR TESTS
    public DiversityTargetController(DiversityTargetService diversityTargetService) {
        this.diversityTargetService = diversityTargetService;
    }

    // ✅ REQUIRED FOR SPRING
    public DiversityTargetController() {
    }

    @PostMapping
    public DiversityTarget createTarget(@RequestBody DiversityTarget target) {
        return diversityTargetService.createTarget(target);
    }

    @GetMapping
    public List<DiversityTarget> getAllTargets() {
        return diversityTargetService.getAllTargets();
    }

    @GetMapping("/year/{year}")
    public List<DiversityTarget> getTargetsByYear(@PathVariable int year) {
        return diversityTargetService.getTargetsByYear(year);
    }

    @DeleteMapping("/{id}")
    public void deactivateTarget(@PathVariable Long id) {
        diversityTargetService.deactivateTarget(id);
    }
}
