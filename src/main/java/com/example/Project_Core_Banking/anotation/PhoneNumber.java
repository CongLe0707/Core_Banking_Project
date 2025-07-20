package com.example.Project_Core_Banking.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import  com.example.Project_Core_Banking.anotation.impl.PhoneNumberImpl;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberImpl.class)
public @interface PhoneNumber {
    String message() default "Số điện thoại chỉ được chứa ký tự số";
    boolean required() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 