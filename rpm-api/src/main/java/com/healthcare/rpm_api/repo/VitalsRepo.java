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
public interface VitalsRepo extends JpaRepository<VitalsModel, Long>{
    @Query("SELECT v FROM VitalsModel v WHERE v.patient.id = :id")
    List<VitalsModel> findBypatient_id(@Param("id") long id); // List is used to return entire objects

    Optional<VitalsModel>findByid(long id); // Used to return only an object that wont have null values ( Optional)
    @Modifying // doesn't force read it just deletes
    @Transactional // ACID
    @Query("DELETE FROM VitalsModel v WHERE v.patient.id = :id")
    int deleteByPatientId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM VitalsModel v WHERE v.id = :id")
    int deletebyid(@Param("id") long id);


}
