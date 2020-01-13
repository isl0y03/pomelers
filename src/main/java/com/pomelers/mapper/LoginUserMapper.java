package com.pomelers.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.pomelers.domain.entity.LoginUser;

@Mapper
public interface LoginUserMapper {

    LoginUser select(String email);

}
