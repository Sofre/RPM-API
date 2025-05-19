package com.healthcare.rpm_api.service;
import com.healthcare.rpm_api.model.DeviceModel;
import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.model.VitalsModel;
import com.healthcare.rpm_api.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthcare.rpm_api.repo.VitalsRepo;


import java.util.List;
import java.util.Optional;



@Service
public class VitalsService {

    @Autowired
    private VitalsRepo vitalsRepo;


    @Autowired
    private PatientRepo patientRepo;


    public VitalsModel addVital(long patientId, VitalsModel vitalsModel) {
        PatientModel patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));
        vitalsModel.setPatient(patient);
        return vitalsRepo.save(vitalsModel); // saves vitals on referencing patient_id
    }

    public List<VitalsModel> getVitalsByPatientId(long patient_id) {
        return vitalsRepo.findBypatient_id(patient_id);
    }

    public Optional<VitalsModel>getVitalsId(long id){
        return vitalsRepo.findByid(id);
    }
    public void deleteAllVitalsByPatientID(long patient_id){
        vitalsRepo.deleteByPatientId(patient_id);
    }
    public void deletebyVitals_Id(long patient_id){
        vitalsRepo.deletebyid(patient_id);
    }

    public VitalsModel saveVitals(VitalsModel vitals) {
        return vitalsRepo.save(vitals); // saves vitals on its own id
    }












    }

