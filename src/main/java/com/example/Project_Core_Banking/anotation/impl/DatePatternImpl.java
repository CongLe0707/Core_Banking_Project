package com.example.Project_Core_Banking.anotation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.example.Project_Core_Banking.anotation.DatePattern;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DatePatternImpl implements ConstraintValidator<DatePattern, String> {
    private String pattern;

    @Override
    public void initialize(DatePattern annotation) {
        pattern = annotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            OffsetDateTime.parse(value, formatter);
            return true;
        } catch (DateTimeParseException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Invalid date format, must match pattern: " + pattern
            ).addConstraintViolation();
            return false;
        }
    }
}