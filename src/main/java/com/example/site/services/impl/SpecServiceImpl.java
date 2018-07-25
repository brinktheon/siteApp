package com.example.site.services.impl;

import com.example.site.model.Specialty;
import com.example.site.repositories.SpecialtyRepository;
import com.example.site.services.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecServiceImpl implements SpecService {


    private final SpecialtyRepository repository;

    @Autowired
    public SpecServiceImpl(SpecialtyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Specialty> getSpecialties(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }
}
