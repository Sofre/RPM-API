package com.healthcare.rpm_api.service;
import com.healthcare.rpm_api.model.DeviceModel;
import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.model.VitalsModel;
import com.healthcare.rpm_api.repo.DeviceRepo;
import com.healthcare.rpm_api.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    DeviceRepo deviceRepo;

    @Autowired
    PatientRepo patientRepo;



    // Save a new vital record
    public DeviceModel addDevice(long patientId, DeviceModel deviceModel) {
        // Find the patient by ID
        PatientModel patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));


        deviceModel.setPatient(patient);
        return deviceRepo.save(deviceModel);
    }
    // Retrieve all vital records for a specific patient


    public List<DeviceModel> getDeviceByPatientId(long patient_id) {
        return deviceRepo.findBypatient_id(patient_id);
    }
    public Optional<DeviceModel>getDeviceId(long id){
        return deviceRepo.findByid(id);
    }

    public void deleteAllDevicesByPatientID(long patient_id){
        deviceRepo.deleteByPatientId(patient_id);
    }
    public void deletebyDevice_Id(long patient_id){
        deviceRepo.deletebyid(patient_id);
    }
    public DeviceModel saveDevice(DeviceModel deviceModel) {
        return deviceRepo.save(deviceModel); // saves vitals on its own id
    }

}
