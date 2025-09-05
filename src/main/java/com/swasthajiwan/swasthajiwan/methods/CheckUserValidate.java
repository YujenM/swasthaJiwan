package com.swasthajiwan.swasthajiwan.methods;

import com.swasthajiwan.swasthajiwan.model.Validate;
import com.swasthajiwan.swasthajiwan.repository.ValidateRepository;
import org.springframework.stereotype.Component;

@Component
public class CheckUserValidate {
    private final ValidateRepository validateRepository;
    public CheckUserValidate(ValidateRepository validateRepository){
        this.validateRepository=validateRepository;
    }

    public boolean isValidate(String userId){
        return validateRepository.findByUserId(userId)
                .map(Validate::getIsValidate)
                .orElse(Boolean.FALSE);
    }
}
