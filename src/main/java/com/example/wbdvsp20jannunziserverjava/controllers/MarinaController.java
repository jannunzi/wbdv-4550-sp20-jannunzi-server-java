package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Marina;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface MarinaController {
    @GetMapping("/marinas")
    public List<Marina> findAllMarinas();
    @GetMapping("/marinas/{id}")
    public Marina findMarinaById(Integer id);
    @PostMapping("/marinas")
    public Marina createMarina(Marina sailboat);
    @PutMapping("/marinas/{id}")
    public int updateMarina(Integer id, Marina sailboat);
    @DeleteMapping("/marinas/{id}")
    public int deleteMarina(Integer id);
}
