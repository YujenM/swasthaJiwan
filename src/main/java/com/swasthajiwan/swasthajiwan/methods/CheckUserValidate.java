package com.swasthajiwan.swasthajiwan.methods;

import com.swasthajiwan.swasthajiwan.model.Validate;
import com.swasthajiwan.swasthajiwan.repository.UserRoleRepository;
import com.swasthajiwan.swasthajiwan.repository.ValidateRepository;
import org.springframework.stereotype.Component;

@Component
public class CheckUserValidate {
    private final ValidateRepository validateRepository;
    private final UserRoleRepository userRoleRepository;
    public CheckUserValidate(ValidateRepository validateRepository,UserRoleRepository userRoleRepository){
        this.validateRepository=validateRepository;
        this.userRoleRepository=userRoleRepository;
    }
    public boolean findUser(String userId) {
        return !userRoleRepository.findByUserId(userId).isEmpty();
    }

    public boolean isValidate(String userId){
        return validateRepository.findByUserId(userId)
                .map(Validate::getIsValidate)
                .orElse(Boolean.FALSE);
    }
}
