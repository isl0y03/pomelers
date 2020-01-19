package com.pomelers.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pomelers.domain.entity.LoginUser;
import com.pomelers.mapper.LoginUserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LoginUserMapper mapper;

    @Override
    public LoginUser select(final Integer id) {
        final LoginUser user = this.mapper.selectById(id);
        return user;
    }

    @Override
    public LoginUser select(final String email) {
        final LoginUser user = this.mapper.selectByEmail(email);
        return user;
    }

    @Override
    public void register(final LoginUser loginUser) {
        this.mapper.insert(loginUser);
    }

}
