package com.pomelers.domain.model;

public class SignUpForm {

    private String email;

    private String password;

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
