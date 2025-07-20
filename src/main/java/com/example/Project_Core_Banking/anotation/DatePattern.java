package com.example.Project_Core_Banking.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.example.Project_Core_Banking.anotation.impl.DatePatternImpl;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DatePatternImpl.class)
public @interface DatePattern {
    String pattern() default "yyyy-MM-dd'T'HH:mm:ss.SSSSXXX";
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
