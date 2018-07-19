package com.example.site.controllers;

import com.example.site.model.Doctor;
import com.example.site.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EntityController {

    final private DoctorRepository repository;

    @Autowired
    public EntityController(DoctorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllNotes() {
        return repository.findAll();
    }
}
