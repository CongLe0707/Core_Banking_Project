package vn.hdbank.delegation.anotation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import vn.hdbank.delegation.anotation.EnumPattern;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumPatternImpl implements ConstraintValidator<EnumPattern, CharSequence> {
    private List<String> acceptedValues;
    private boolean isRequired;

    @Override
    public void initialize(EnumPattern annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
        isRequired = annotation.required();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (context instanceof HibernateConstraintValidatorContext constraintValidatorContext) {
            constraintValidatorContext.addMessageParameter("enumConstants", acceptedValues);
        }

        if (isRequired) {
            return StringUtils.isNotBlank(value) && acceptedValues.contains(value.toString());
        }

        return acceptedValues.isEmpty() || value == null || acceptedValues.contains(value.toString());
    }
}
