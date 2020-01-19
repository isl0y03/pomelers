package com.pomelers.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import com.pomelers.domain.model.validator.ConfirmPassword;
import com.pomelers.domain.model.validator.UniqueEmail;
import com.pomelers.domain.model.validator.ValidationGroups.Attribute;
import com.pomelers.domain.model.validator.ValidationGroups.Relation;
import lombok.Getter;
import lombok.Setter;

@ConfirmPassword(groups = Relation.class)
public class SignUpForm {

    @NotEmpty(groups = Attribute.class)
    @Email(groups = Attribute.class)
    @UniqueEmail(groups = Relation.class)
    @Getter
    @Setter
    private String email;

    @NotEmpty(groups = Attribute.class)
    @Getter
    @Setter
    private String password;

    @NotEmpty(groups = Attribute.class)
    @Getter
    @Setter
    private String confirm;

}
