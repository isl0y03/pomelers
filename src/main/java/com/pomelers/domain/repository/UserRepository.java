package com.pomelers.domain.repository;

import com.pomelers.domain.entity.LoginUser;

public interface UserRepository {

    LoginUser select(Integer id);

    LoginUser select(String email);

    void register(LoginUser loginUser);
}
