package com.pomelers.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.pomelers.domain.model.SignUpForm;

public interface UserService extends UserDetailsService {

    void register(SignUpForm form);

}
