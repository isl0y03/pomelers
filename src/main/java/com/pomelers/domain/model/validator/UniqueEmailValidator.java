package com.pomelers.domain.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.pomelers.domain.entity.LoginUser;
import com.pomelers.domain.repository.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        final LoginUser user = this.repository.select(value);
        return user == null;
    }

}
