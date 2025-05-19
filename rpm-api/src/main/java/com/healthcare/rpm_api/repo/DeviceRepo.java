package com.healthcare.rpm_api.repo;

import com.healthcare.rpm_api.model.DeviceModel;
import com.healthcare.rpm_api.model.VitalsModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepo extends JpaRepository<DeviceModel, Long> {
    @Query("SELECT v FROM DeviceModel v WHERE v.patient.id = :id")
    List<DeviceModel> findBypatient_id(@Param("id") long id);

    Optional<DeviceModel>findByid(long id);

    @Modifying // doesn't force read it just deletes
    @Transactional
    @Query("DELETE FROM DeviceModel v WHERE v.patient.id = :id")
    int deleteByPatientId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM DeviceModel v WHERE v.id = :id")
    int deletebyid(@Param("id") long id);



}
