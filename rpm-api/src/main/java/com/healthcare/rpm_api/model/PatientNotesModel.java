package com.healthcare.rpm_api.model;

import jakarta.persistence.*;

@Entity
public class PatientNotesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private String subjective;
    private String objective;
    private String assesment;
    private String plan;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    PatientModel patient;

    public PatientNotesModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjective() {
        return subjective;
    }

    public void setSubjective(String subjective) {
        this.subjective = subjective;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getAssesment() {
        return assesment;
    }

    public void setAssesment(String assesment) {
        this.assesment = assesment;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }
}
