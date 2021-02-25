package com.peijia.auth.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peijia.auth.user.domain.User;

/**
 * @className      UserMapper
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/2/7 11:18
 */
public interface UserMapper extends BaseMapper<User> {

    User findByName(String userName);
}