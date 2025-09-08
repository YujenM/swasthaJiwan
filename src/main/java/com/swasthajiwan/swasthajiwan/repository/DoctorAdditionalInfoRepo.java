package com.swasthajiwan.swasthajiwan.repository;

import com.swasthajiwan.swasthajiwan.model.DoctorAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorAdditionalInfoRepo extends JpaRepository<DoctorAdditionalInfo,String> {
    List<DoctorAdditionalInfo> findByLicenseNumber(String licenseNumber);
}
