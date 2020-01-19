package com.pomelers.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.pomelers.domain.entity.LoginUser;

@Mapper
public interface LoginUserMapper {

    LoginUser selectById(Integer id);

    LoginUser selectByEmail(String email);

    void insert(LoginUser loginUser);

}
