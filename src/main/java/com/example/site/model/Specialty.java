package com.example.site.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false,
            name = "specId")
    private Long specId;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "specialties")
    @JsonBackReference
    private List<Doctor> doctors;

    public Specialty() {
    }

    public Specialty(@NotNull String name) {
        this.name = name;
    }

    public Specialty(Long specId, @NotNull String name) {
        this.specId = specId;
        this.name = name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
