package com.pomelers.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import com.pomelers.domain.model.validator.ConfirmPassword;
import com.pomelers.domain.model.validator.UniqueEmail;
import com.pomelers.domain.model.validator.ValidationGroups.Attribute;
import com.pomelers.domain.model.validator.ValidationGroups.Relation;

@ConfirmPassword(groups = Relation.class)
public class SignUpForm {

    @NotEmpty(groups = Attribute.class)
    @Email(groups = Attribute.class)
    @UniqueEmail(groups = Relation.class)
    private String email;

    @NotEmpty(groups = Attribute.class)
    private String password;

    @NotEmpty(groups = Attribute.class)
    private String confirm;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getConfirm() {
        return this.confirm;
    }

    public void setConfirm(final String confirm) {
        this.confirm = confirm;
    }

}
