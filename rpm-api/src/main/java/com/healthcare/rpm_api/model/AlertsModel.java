package com.healthcare.rpm_api.model;

import jakarta.persistence.*;

@Entity
public class AlertsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

    private String type;
    private String message;
    private String status;


    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceModel device;




    public AlertsModel() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeviceModel getDevice() {
        return device;
    }

    public void setDevice(DeviceModel device) {
        this.device = device;
    }


}
