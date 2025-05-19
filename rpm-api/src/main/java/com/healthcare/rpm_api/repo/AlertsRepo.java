package com.healthcare.rpm_api.repo;

import com.healthcare.rpm_api.model.AlertsModel;
import com.healthcare.rpm_api.model.DeviceModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlertsRepo extends JpaRepository<AlertsModel , Long> {
    @Query("SELECT v FROM AlertsModel v WHERE v.device.id = :id")
    List<AlertsModel> findBydevice_id(@Param("id") long id);

    Optional<AlertsModel> findByid(long id);

    @Modifying // doesn't force read it just deletes
    @Transactional
    @Query("DELETE FROM AlertsModel v WHERE v.device.id = :id")
    int deleteByDevicetId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM AlertsModel v WHERE v.id = :id")
    int deletebyid(@Param("id") long id);
}
