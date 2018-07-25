package com.example.site.controllers;

import com.example.site.model.Specialty;
import com.example.site.services.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpecialtyController {

    private final SpecService specService;

    @Autowired
    public SpecialtyController(SpecService specService) {
        this.specService = specService;
    }

    @RequestMapping(
            value = "/specialties",
            params = { "page", "size" },
            method = RequestMethod.GET
    )
    List<Specialty> getAllSpecialties(@RequestParam("page") int page, @RequestParam("size") int size){
        return specService.getSpecialties(page, size);
    }
}
