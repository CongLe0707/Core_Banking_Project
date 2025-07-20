package vn.hdbank.delegation.anotation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import vn.hdbank.delegation.anotation.PhoneNumber;

public class PhoneNumberImpl implements ConstraintValidator<PhoneNumber, String> {
    private boolean isRequired;

    @Override
    public void initialize(PhoneNumber annotation) {
        isRequired = annotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!isRequired && StringUtils.isBlank(value)) {
            return true;
        }
        if (StringUtils.isBlank(value)) {
            return false;
        }
        return value.matches("^[0-9]+$");
    }
} 