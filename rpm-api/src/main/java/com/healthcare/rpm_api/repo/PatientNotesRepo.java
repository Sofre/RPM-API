package com.healthcare.rpm_api.repo;

import com.healthcare.rpm_api.model.PatientNotesModel;
import com.healthcare.rpm_api.model.VitalsModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientNotesRepo extends JpaRepository<PatientNotesModel , Long> {

    @Query("SELECT v FROM PatientNotesModel v WHERE v.patient.id = :id")
    List<PatientNotesModel> findBypatient_id(@Param("id") long id);

    @Query("SELECT v FROM PatientNotesModel v WHERE v.id = :id")
    PatientNotesModel findById(@Param("id") long id);

    @Modifying // doesn't force read it just deletes
    @Transactional
    @Query("DELETE FROM PatientNotesModel v WHERE v.patient.id = :id")
    int deleteByPatientId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM PatientNotesModel v WHERE v.id = :id")
    int deletebyid(@Param("id") long id);





}
