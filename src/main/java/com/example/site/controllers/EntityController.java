package com.example.site.controllers;

import com.example.site.model.Doctor;
import com.example.site.services.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntityController {

    final private DocService service;

    @Autowired
    public EntityController(DocService service) {
        this.service = service;
    }

    @RequestMapping(
            value = "/doctors",
            params = { "page", "size" },
            method = RequestMethod.GET
    )
    List<Doctor> getAllDoctors(@RequestParam("page") int page, @RequestParam("size") int size){
        return service.getDoctors(page, size);
    }

    @RequestMapping(
            value = "/doctors/{specialty}",
            params = {"page", "size"},
            method = RequestMethod.GET
    )
    public List<Doctor> getDoctorsBySeprcialty(@RequestParam("page") int page, @RequestParam("size") int size, @PathVariable(value = "specialty") String specialty){
        return service.getDoctorsBySpecialty(page, size, specialty);
    }
}
