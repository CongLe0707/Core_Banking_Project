package vn.hdbank.delegation.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import vn.hdbank.delegation.anotation.impl.EnumPatternImpl;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = EnumPatternImpl.class)
public @interface EnumPattern {
    Class<? extends Enum<?>> enumClass();
    String message() default "must be any of enum {enumConstants}";
    boolean required() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
