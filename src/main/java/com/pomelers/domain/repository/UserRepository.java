package com.pomelers.domain.repository;

import com.pomelers.domain.entity.LoginUser;

public interface UserRepository {
    LoginUser select(String email);
}
