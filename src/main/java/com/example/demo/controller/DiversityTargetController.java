package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diversity-targets")
public class DiversityTargetController {

    private final DiversityTargetService diversityTargetService;

    public DiversityTargetController(DiversityTargetService diversityTargetService) {
        this.diversityTargetService = diversityTargetService;
    }

    @PostMapping
    public ResponseEntity<DiversityTarget> createTarget(@RequestBody DiversityTarget target) {
        return ResponseEntity.ok(diversityTargetService.createTarget(target));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<DiversityTarget>> getTargetsByYear(@PathVariable int year) {
        return ResponseEntity.ok(diversityTargetService.getTargetsByYear(year));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateTarget(@PathVariable Long id) {
        diversityTargetService.deactivateTarget(id);
        return ResponseEntity.ok().build();
    }
}
