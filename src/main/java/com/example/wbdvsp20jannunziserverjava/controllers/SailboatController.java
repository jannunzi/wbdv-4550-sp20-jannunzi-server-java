package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Sailboat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface SailboatController {
    @GetMapping("/sailboats")
    public List<Sailboat> findAllSailboats();
    @GetMapping("/sailboats/{id}")
    public Sailboat findSailboatById(Integer id);
@PostMapping("/sailboats")
public Sailboat createSailboat(Sailboat sailboat);
    @PutMapping("/sailboats/{id}")
    public int updateSailboat(Integer id, Sailboat sailboat);
    @DeleteMapping("/sailboats/{id}")
    public int deleteSailboat(Integer id);
}

// Which of the following methods correctly implement a
// RESTful endpoint that return the list of all sailboats
