package com.healthcare.rpm_api.repo;
import com.healthcare.rpm_api.model.PatientModel;
import com.healthcare.rpm_api.model.VitalsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
// Storage to database and CRUD
public interface PatientRepo extends  JpaRepository<PatientModel, Long> {


    Optional<PatientModel> findById(long id);//optional used for check methods and null values with out no errors



    Optional<PatientModel> deleteById(long id);// delete by id



}
