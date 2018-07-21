package com.example.site.repositories;

import com.example.site.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.specialty) = LOWER(:specialty)")
    Page<Doctor> findBySpecialty(@Param("specialty") String specialty, Pageable pageable);

}
