package com.example.site.services;

import com.example.site.model.Specialty;

import java.util.List;

public interface SpecService {

    List<Specialty> getSpecialties(int page, int size);
}
