package com.pomelers.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import com.pomelers.domain.model.validator.ConfirmPassword;
import com.pomelers.domain.model.validator.UniqueEmail;

@ConfirmPassword
public class SignUpForm {

    @NotEmpty
    @Email
    @UniqueEmail
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
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
