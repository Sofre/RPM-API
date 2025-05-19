package com.healthcare.rpm_api.controller;
import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.repo.PatientRepo;
import com.healthcare.rpm_api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
// so i have to map id of patient to vitals and devices
// create a new for alerts

@RequestMapping("/rpm-api/patients") // header requests for server
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientModel> getAllPatients() {
        return patientService.getAllPatients();
    }
    @PostMapping
    public PatientModel addPatient(@RequestBody PatientModel patientModel){
        return patientService.addPatient(patientModel);
    }
    @DeleteMapping
    public void deleteAllPatients(){
        patientService.deleteAllPatients();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> getByID(@PathVariable long id){
        return patientService.findbyID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientModel>putByID(@PathVariable long id, @RequestBody PatientModel patientModel){
        Optional<PatientModel> existingPatient = patientService.findbyID(id);

        if (existingPatient.isPresent()) {
            PatientModel updatedPatient = existingPatient.get(); // if a object of existing patient is here gets the entire object
            updatedPatient.setName(patientModel.getName()); // A reference is made again and this new object updates everything
            updatedPatient.setAge(patientModel.getAge());
            patientService.addPatient(updatedPatient); // stored and saved
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

   @DeleteMapping("/{id}")
   public ResponseEntity<PatientModel> deletebyID(@PathVariable long id){
        patientService.deletebyID(id);
       return new ResponseEntity<>(HttpStatusCode.valueOf(200)); // ajde bree
    }



}
