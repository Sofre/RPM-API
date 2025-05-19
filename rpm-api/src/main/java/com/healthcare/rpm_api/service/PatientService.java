package com.healthcare.rpm_api.service;
import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;


    public List<PatientModel> getAllPatients(){
      return patientRepo.findAll();
    }
    public PatientModel addPatient(PatientModel patientModel){
        return patientRepo.saveAndFlush(patientModel);
    }
    public void deleteAllPatients(){
        patientRepo.deleteAll();
    }
    public Optional<PatientModel>findbyID(long id){
        return  patientRepo.findById(id);
    }
    public Optional<PatientModel> updatedPatient(long id, PatientModel newPatient) {
        return patientRepo.findById(id).map(patientModel -> {
            patientModel.setName(newPatient.getName());
            patientModel.setSurname(newPatient.getSurname());
            patientModel.setAge(newPatient.getAge());
            patientModel.setGender(newPatient.getGender());
            return patientRepo.save(patientModel);
        }); // take the new object and update by getting the new object's attributes and setting the existing ones with new values
    }
    public Optional<PatientModel>deletebyID(long id){
        return patientRepo.deleteById(id);
    }







}
