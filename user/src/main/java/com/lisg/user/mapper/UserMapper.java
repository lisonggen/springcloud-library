package com.lisg.user.mapper;

import common.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public Integer insert(User user);

    public List<User> selectUsers(@Param("userId") Long userId,
                                  @Param("userName") String userName,
                                  @Param("email") String email,
                                  @Param("phone") String phone,
                                  @Param("idCardType") String idCardType,
                                  @Param("idCardNum") String idCardNum);
}
