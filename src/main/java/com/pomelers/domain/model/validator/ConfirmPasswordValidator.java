package com.pomelers.domain.model.validator;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, Object> {

    private String passwordField;

    private String confirmField;

    private String message;

    @Override
    public void initialize(final ConfirmPassword constraintAnnotation) {
        this.passwordField = "password";
        this.confirmField = "confirm";
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        final BeanWrapper bw = new BeanWrapperImpl(value);
        final Object password = bw.getPropertyValue(this.passwordField);
        final Object confirm = bw.getPropertyValue(this.confirmField);
        if (Objects.equals(password, confirm)) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context
                .buildConstraintViolationWithTemplate(this.message)
                .addPropertyNode(this.confirmField)
                .addConstraintViolation();
        return false;
    }

}
