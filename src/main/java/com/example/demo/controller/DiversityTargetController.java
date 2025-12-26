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

    @PostMapping
    public DiversityTarget createTarget(@RequestBody DiversityTarget target) {
        return diversityTargetService.createTarget(target);
    }

    @GetMapping
    public List<DiversityTarget> getAllTargets() {
        return diversityTargetService.getAllTargets();
    }

    // 🔥 FIXES t15
    @GetMapping("/year/{year}")
    public List<DiversityTarget> getByYear(@PathVariable int year) {
        return diversityTargetService.getByYear(year);
    }

    @DeleteMapping("/{id}")
    public void deactivateTarget(@PathVariable Long id) {
        diversityTargetService.deactivateTarget(id);
    }
}
