package com.healthcare.rpm_api.controller;
import com.healthcare.rpm_api.model.PatientNotesModel;
import com.healthcare.rpm_api.repo.PatientNotesRepo;
import com.healthcare.rpm_api.service.PatientNotesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rpm-api/patients")
public class PatientNotesController {
    @Autowired
    PatientNotesService patientNotesService;

    @PostMapping("/{id}/notes")
    public PatientNotesModel addPatientNotes_byPatient_Id(@PathVariable("id") long id , @RequestBody PatientNotesModel patientNotesModel){
        return patientNotesService.addPatient_notes_byID(id,patientNotesModel);
    }
    @GetMapping("/{id}/notes")
    public List<PatientNotesModel> getAllPatientNotes_patientId(@PathVariable("id") long id){
        return patientNotesService.getPatient_info(id);
    }
    @GetMapping("/{id}/notes/{notes_id}")
    public PatientNotesModel getByPatientNotes_Id(@PathVariable("notes_id") long id){
        return patientNotesService.getPatientNotes_byID(id);
    }
    @DeleteMapping("/{id}/notes")
    public void deleteALLVitalSignsbyPatient_Id(@PathVariable("id") long id) {
        patientNotesService.deleteAllNotesByPatientID(id);
    }

    @DeleteMapping("/{id}/notes/{notes_id}")
    public void deletebyVitals_id(@PathVariable("notes_id") long id) {
        patientNotesService.deletebyNotes_Id(id);
    }
}
