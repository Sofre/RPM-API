package com.healthcare.rpm_api.service;
import com.healthcare.rpm_api.model.AlertsModel;
import com.healthcare.rpm_api.model.DeviceModel;
import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.model.VitalsModel;
import com.healthcare.rpm_api.repo.AlertsRepo;

import com.healthcare.rpm_api.repo.DeviceRepo;
import com.healthcare.rpm_api.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertsService {

    @Autowired
    AlertsRepo alertsRepo;

    @Autowired
    DeviceRepo deviceRepo;



    // POST on device_id
    public AlertsModel addAlert(long patientId, AlertsModel alertsModel) {
        DeviceModel deviceModel = deviceRepo.findByid(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));

        alertsModel.setDevice(deviceModel);
        return alertsRepo.save(alertsModel);
    }
    // GET ALL on device_id
    public List<AlertsModel>getAlertsbyDevice_iD(long id){
        return alertsRepo.findBydevice_id(id);
    }

    public Optional<AlertsModel>getAlertbyId(long id){
        return alertsRepo.findByid(id);
    }

    public void deleteAllAlertsByDeviceID(long device_id){
        alertsRepo.deleteByDevicetId(device_id);
    }
    public void deletebyAlerts_Id(long device_id){
        alertsRepo.deletebyid(device_id);
    }
    public AlertsModel SaveAlertsb(AlertsModel alertsModel){
        return alertsRepo.save(alertsModel);
    }
}
