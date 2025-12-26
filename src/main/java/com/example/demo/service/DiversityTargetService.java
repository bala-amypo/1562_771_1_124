package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;

import java.util.List;

public interface DiversityTargetService {

    DiversityTarget create(DiversityTarget target);

    void deactivate(Long id);

    List<DiversityTarget> getTargetsByYear(int year);


    @GetMapping("/year/{year}")
public List<DiversityTarget> getByYear(@PathVariable int year) {
    return diversityTargetService.getTargetsByYear(year);
}

}
