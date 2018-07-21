package com.example.site.repositories;

import com.example.site.model.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.specialty) = LOWER(:specialty)")
    List<Doctor> findBySpecialty(@Param("specialty") String specialty);
}
