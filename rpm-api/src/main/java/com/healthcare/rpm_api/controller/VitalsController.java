package com.healthcare.rpm_api.controller;
import com.healthcare.rpm_api.model.DeviceModel;
import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.model.VitalsModel;
import com.healthcare.rpm_api.service.VitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/rpm-api/patients")
@RestController
public class VitalsController {

    @Autowired
    VitalsService vitalsService;


    @GetMapping("/{id}/vitals") // all vital scans done on patient
    public List<VitalsModel> getVitalsBypatient_id(@PathVariable("id") long id) {
        System.out.println("GET endpoint hit with ID: " + id);
        return vitalsService.getVitalsByPatientId(id);
    }

    @GetMapping("/{id}/vitals/{vitals_id}") // id on vitals scan on patient
    public Optional<VitalsModel> getDevicebyId(@PathVariable("vitals_id") long id) {
        return vitalsService.getVitalsId(id);
    }

    // Add new vital signs for a specific patient
    @PostMapping("/{id}/vitals") // posting on id on patient
    public VitalsModel addVitalSigns(@PathVariable("id") long id, @RequestBody VitalsModel vitalSigns) {
        return vitalsService.addVital(id, vitalSigns);
    }

    @DeleteMapping("/{id}/vitals")
    public void deleteALLVitalSignsbyPatient_Id(@PathVariable("id") long id) {
        vitalsService.deleteAllVitalsByPatientID(id);
    }

    @DeleteMapping("/{id}/vitals/{vitals_id}")
    public void deletebyVitals_id(@PathVariable("vitals_id") long id) {
        vitalsService.deletebyVitals_Id(id);
    }

    @PutMapping("/{id}/vitals/{vitals_id}")
    public Optional<VitalsModel> updatebyVitals_id(@PathVariable("vitals_id") long id, @RequestBody VitalsModel vitalsModel) {


        Optional<VitalsModel> existingVital = vitalsService.getVitalsId(id);
        VitalsModel updatedVitals = existingVital.get();
        updatedVitals.setBody_temp(vitalsModel.getBody_temp());
        updatedVitals.setPulse_rate(vitalsModel.getPulse_rate());
        updatedVitals.setBreathing_rate(vitalsModel.getBreathing_rate());
        updatedVitals.setBlood_pressure(vitalsModel.getBlood_pressure());
        VitalsModel savedVitals = vitalsService.saveVitals(updatedVitals);
        return Optional.ofNullable(savedVitals);



    }
}










