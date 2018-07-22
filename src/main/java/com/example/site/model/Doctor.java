package com.example.site.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "doctor")
public class Doctor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false,
            name = "docId")
    private Long docId;

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    @NotNull
    private Long category;

    @NotNull
    private String workingTime;

    @Transient
    private String spec;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "doctor_specialty",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "docId"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id", referencedColumnName = "specId"))
    @JsonManagedReference
    private List<Specialty> specialties;

    public void transferSpecialtiesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Specialty specialty : specialties) {
            stringBuilder.append(specialty.getName()).append(", ");
        }
        spec = stringBuilder.toString();
    }

    public Doctor() {
    }

    public Doctor(@NotNull String firstName,  @NotNull String secondName,  @NotNull Long category,  @NotNull String workingTime) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.category = category;
        this.workingTime = workingTime;
    }

    public Doctor(Long docId, @NotNull String firstName,  @NotNull String secondName,  @NotNull Long category,  @NotNull String workingTime) {
        this.docId = docId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.category = category;
        this.workingTime = workingTime;
    }

    public String getSpec() {
        return spec;
    }

    @Transient
    public void setSpec(String spec) {
        this.spec = spec;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }
}
