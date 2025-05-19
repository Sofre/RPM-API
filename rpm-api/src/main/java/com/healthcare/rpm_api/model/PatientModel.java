package com.healthcare.rpm_api.model;

import com.healthcare.rpm_api.repo.AlertsRepo;
import jakarta.persistence.*;

import java.util.List;

// First of is defining core data. Entity sets or Relations
@Entity
public class PatientModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    long id ; // will use for mapping relation with vitals and devices                      // represents identifier for this resource
    private int patient_id;
    private String name;
    private String surname;
    private String gender;
    private int age;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<VitalsModel> vitals;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<DeviceModel> devices;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<PatientNotesModel> patientNotes;









    public PatientModel() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
