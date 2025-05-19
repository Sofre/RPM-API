package com.healthcare.rpm_api.model;
import jakarta.persistence.*;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class VitalsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    private float body_temp;
    private int pulse_rate;
    private int breathing_rate;
    private int blood_pressure;
    private LocalDateTime recordedAt;  // When a POST is send it has to capture the time



    @ManyToOne // many to one because one patient can have many vital scans and every recorded one will be a object identified and joined in a column in patient model
    @JoinColumn(name = "patient_id") //entire object is joined into a column in patient entity
    private PatientModel patient;


    VitalsModel(){}



    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getBody_temp() {
        return body_temp;
    }

    public void setBody_temp(float body_temp) {
        this.body_temp = body_temp;
    }

    public int getPulse_rate() {
        return pulse_rate;
    }

    public void setPulse_rate(int pulse_rate) {
        this.pulse_rate = pulse_rate;
    }

    public int getBreathing_rate() {
        return breathing_rate;
    }

    public void setBreathing_rate(int breathing_rate) {
        this.breathing_rate = breathing_rate;
    }

    public int getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(int blood_pressure) {
        this.blood_pressure = blood_pressure;
    }


}
