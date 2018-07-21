package com.example.site.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Table(name = "doctor")
public class Doctor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long docId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @NotBlank
    private Long category;

    @NotBlank
    private String specialty;

    @NotBlank
    private String workingTime;

    public Doctor() {
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "docId=" + docId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", category=" + category +
                ", specialty='" + specialty + '\'' +
                ", workingTime='" + workingTime + '\'' +
                '}';
    }
}
