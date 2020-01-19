package com.pomelers.domain.entity;

import lombok.Getter;
import lombok.Setter;

public class LoginUser {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;
}
