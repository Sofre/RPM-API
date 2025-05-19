package com.healthcare.rpm_api.controller;

import com.healthcare.rpm_api.model.DeviceModel;
import com.healthcare.rpm_api.model.VitalsModel;
import com.healthcare.rpm_api.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rpm-api/patients")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/{id}/devices")
        DeviceModel addDevicesbypatient_Id(@PathVariable("id") long id, @RequestBody DeviceModel deviceModel){
        System.out.println("POST point  with patient_id" + id );
        return deviceService.addDevice(id,deviceModel);

    }
    @GetMapping("/{id}/devices") // on all on patient_id
    public List<DeviceModel> getDevicesByPatientId(@PathVariable("id") long id) {
       return deviceService.getDeviceByPatientId(id);
    }
    @GetMapping("/{id}/devices/{device_id}")
    public Optional<DeviceModel> getDevicebyId(@PathVariable("device_id") long id){
        return deviceService.getDeviceId(id); // ajde bre kume
    }
    @DeleteMapping("/{id}/devices")
    public void deleteALLVitalSignsbyPatient_Id(@PathVariable("id") long id) {
        deviceService.deleteAllDevicesByPatientID(id);
    }

    @DeleteMapping("/{id}/devices/{devices_id}")
    public void deletebyVitals_id(@PathVariable("devices_id") long id) {
        deviceService.deletebyDevice_Id(id);
    }

    @PutMapping("/{id}/devices/{devices_id}")
    public Optional<DeviceModel> updatebyVitals_id(@PathVariable("devices_id") long id, @RequestBody DeviceModel deviceModel) {


        Optional<DeviceModel> existingdevice = deviceService.getDeviceId(id);
        DeviceModel updatedDeviceStats = existingdevice.get();
        updatedDeviceStats.setDeviceName(deviceModel.getDeviceName());
        updatedDeviceStats.setDeviceType(deviceModel.getDeviceType());
        updatedDeviceStats.setDeviceFunction(deviceModel.getDeviceFunction());
        DeviceModel savedDevicestats = deviceService.saveDevice(updatedDeviceStats);
        return Optional.ofNullable(savedDevicestats);



    }

}
