package com.example.site.services;

import com.example.site.model.Doctor;

import java.util.List;

public interface DocService {

    List<Doctor> getDoctors(int page, int size);

    List<Doctor> getDoctorsBySpecialty(String specialty);
}
