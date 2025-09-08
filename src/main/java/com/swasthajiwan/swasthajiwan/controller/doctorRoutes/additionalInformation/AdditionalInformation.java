package com.swasthajiwan.swasthajiwan.controller.doctorRoutes.additionalInformation;

import com.swasthajiwan.swasthajiwan.dto.DoctorInfoRequest;
import com.swasthajiwan.swasthajiwan.model.DoctorAdditionalInfo;
import com.swasthajiwan.swasthajiwan.services.doctor.additionalInfo.DoctorInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class AdditionalInformation {
    private final DoctorInfoService doctorInfoService;


    public AdditionalInformation(DoctorInfoService doctorInfoService){

        this.doctorInfoService=doctorInfoService;
    }

    @PostMapping("/additionalInfo")
    public ResponseEntity<?> additionalInfo(@RequestBody DoctorInfoRequest request) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object principal = auth.getPrincipal();
            String userId = (principal instanceof UserDetails)
                    ? ((UserDetails) principal).getUsername()
                    : principal.toString();

            DoctorAdditionalInfo savedInfo = doctorInfoService.saveDocttorInfo(request, userId);

            DoctorInfoRequest responseDto = new DoctorInfoRequest();
            responseDto.setUserId(savedInfo.getUserId());
            responseDto.setSpecializationId(savedInfo.getSpecializationId());
            responseDto.setLicenseNumber(savedInfo.getLicenseNumber());
            responseDto.setBio(savedInfo.getBio());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Map.of(
                            "message", "Doctor information saved successfully",
                            "data", responseDto
                    ));


        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", ex.getMessage()));
        }
    }
}
