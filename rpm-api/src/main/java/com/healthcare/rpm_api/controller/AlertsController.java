package com.healthcare.rpm_api.controller;
import com.healthcare.rpm_api.model.AlertsModel;
import com.healthcare.rpm_api.model.DeviceModel;
import com.healthcare.rpm_api.repo.AlertsRepo;
import com.healthcare.rpm_api.service.AlertsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rpm-api/patients/{id}/devices")
public class AlertsController {

    @Autowired
    AlertsService alertsService;
    // not linked with Patients_id ... thinking about using /{id}/devices/{device_id}/alerts and mapping two id's ?? or just operate GET proto
    @PostMapping("/{device_id}/alerts")
    AlertsModel addDevicesbypatient_Id(@PathVariable("device_id") long id, @RequestBody AlertsModel alertsModel) {
        return alertsService.addAlert(id,alertsModel);
    }

    @GetMapping("/{device_id}/alerts") // on all device_id
    public List<AlertsModel> getDevicesByPatientId(@PathVariable("device_id") long id) {
        return alertsService.getAlertsbyDevice_iD(id);
    }

    // Get by id
    @GetMapping("/{device_id}/alerts/{alerts_id}")
    public Optional<AlertsModel> getAlertsbyId(@PathVariable("alerts_id") long id){
        return alertsService.getAlertbyId(id);
    }


    @DeleteMapping("/{device_id}/alerts")
    public void deleteALLVitalSignsbyPatient_Id(@PathVariable("device_id") long id) {
        alertsService.deleteAllAlertsByDeviceID(id);
    }

    @DeleteMapping("/{device_id}/alerts/{alerts_id}")
    public void deletebyVitals_id(@PathVariable("alerts_id") long id) {
       alertsService.deletebyAlerts_Id(id);
    }
    // PATCH by id --> USE PATCH ON STATUS
    @PatchMapping("/{device_id}/alerts/{alerts_id}")
    public Optional<AlertsModel> patchingfieldAlerts(@PathVariable("alerts_id") long id ,@RequestBody AlertsModel alertsModel){

        Optional<AlertsModel> existingalerts = alertsService.getAlertbyId(id);
        AlertsModel updatedAlerts= existingalerts.get(); // gets id
        updatedAlerts.setStatus(alertsModel.getStatus()); // sets

        AlertsModel savedAlerts = alertsService.SaveAlertsb(updatedAlerts);
        return Optional.ofNullable(savedAlerts);
    }
}
