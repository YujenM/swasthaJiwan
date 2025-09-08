package com.swasthajiwan.swasthajiwan.services.doctor.additionalInfo;

import com.swasthajiwan.swasthajiwan.dto.DoctorInfoRequest;
import com.swasthajiwan.swasthajiwan.methods.CheckUserValidate;
import com.swasthajiwan.swasthajiwan.model.DoctorAdditionalInfo;
import com.swasthajiwan.swasthajiwan.repository.DoctorAdditionalInfoRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class DoctorInfoService {
    private final DoctorAdditionalInfoRepo doctorAdditionalInfoRepo;
    private final CheckUserValidate checkUserValidate;



    public DoctorInfoService(DoctorAdditionalInfoRepo doctorAdditionalInfoRepo,CheckUserValidate checkUserValidate){
        this.doctorAdditionalInfoRepo=doctorAdditionalInfoRepo;
        this.checkUserValidate=checkUserValidate;
    }
    public DoctorAdditionalInfo saveDocttorInfo(DoctorInfoRequest request,String userId){
        DoctorAdditionalInfo info=new DoctorAdditionalInfo();
        boolean isUser=checkUserValidate.findUser(userId);
        if(!isUser){
            throw new RuntimeException("User not found ");
        }
        List<DoctorAdditionalInfo> existingDoctors =
                doctorAdditionalInfoRepo.findByLicenseNumber(request.getLicenseNumber());

        if (!existingDoctors.isEmpty()) {
            throw new RuntimeException("License number already exists: " + request.getLicenseNumber());
        }



        info.setUserId(userId);
        info.setSpecializationId(request.getSpecializationId());
        info.setLicenseNumber(request.getLicenseNumber());
        info.setBio(request.getBio());
        info.setCreatedAt(LocalDateTime.now());
        return doctorAdditionalInfoRepo.save(info);
    }
}
