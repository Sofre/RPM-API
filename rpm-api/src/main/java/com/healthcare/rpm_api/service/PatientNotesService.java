package com.healthcare.rpm_api.service;

import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.model.PatientNotesModel;
import com.healthcare.rpm_api.repo.PatientNotesRepo;
import com.healthcare.rpm_api.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientNotesService {
    @Autowired
    PatientNotesRepo patientNotesRepo;

    @Autowired
    PatientRepo patientRepo;

    public PatientNotesModel addPatient_notes_byID(long patientId , PatientNotesModel patientNotesModel){
        PatientModel patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));
        patientNotesModel.setPatient(patient);
        return patientNotesRepo.save(patientNotesModel);

    }
    // GET ALL OBJECTS IN LIST BY FOREIGN ID PATIENT ID
    public List<PatientNotesModel> getPatient_info(long id){
        return patientNotesRepo.findBypatient_id(id);
    }
    // GET CERTAIN BY ID
    public PatientNotesModel getPatientNotes_byID(long id){
        return patientNotesRepo.findById(id);
    }
    public void deleteAllNotesByPatientID(long patient_id){
        patientNotesRepo.deleteByPatientId(patient_id);
    }
    public void deletebyNotes_Id(long patient_id){
        patientNotesRepo.deletebyid(patient_id);
    }
}
