package com.healthcare.rpm_api.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class DeviceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

    private String deviceName;
    private String deviceType;
    private String deviceFunction;


    @ManyToOne
    @JoinColumn(name = "patient_id") // new column that will reference PatientModule(id)
    PatientModel patient; // this will control mapping from many to one
    // this means the id of devices will be a child of the id of patients
    // this help linking

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<AlertsModel> alerts;


    public DeviceModel() {
    }

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceFunction() {
        return deviceFunction;
    }

    public void setDeviceFunction(String deviceFunction) {
        this.deviceFunction = deviceFunction;
    }


}
