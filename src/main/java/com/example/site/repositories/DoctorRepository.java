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

    @Query(
            "select d from Doctor d " +
            "inner join d.specialties ds " +
            "where ds.name = 'Allergist'"
            )
    Page<Doctor> findBySpecialty(@Param("specialty") String specialty, Pageable pageable);
}
