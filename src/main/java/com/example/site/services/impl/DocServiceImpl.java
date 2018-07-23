package com.example.site.services.impl;

import com.example.site.model.Doctor;
import com.example.site.repositories.DoctorRepository;
import com.example.site.services.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocServiceImpl implements DocService{

    private final DoctorRepository repository;

    @Autowired
    public DocServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    public List<Doctor> getDoctors(int page, int size){
        List<Doctor> someList = repository.findAll(PageRequest.of(page, size)).getContent();
        someList.forEach(Doctor::transferSpecialtiesToString);
        return someList;
    }

    public List<Doctor> getDoctorsBySpecialty(int page, int size, String specialty){
        List<Doctor> someList = repository.findBySpecialty(specialty, PageRequest.of(page, size)).getContent();
        someList.forEach(Doctor::transferSpecialtiesToString);
        return someList;
    }
}
