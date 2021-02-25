package com.peijia.auth.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peijia.auth.user.domain.User;
import com.peijia.auth.user.mapper.UserMapper;
import com.peijia.auth.user.service.UserService;
import org.springframework.stereotype.Service;
/**
 * @className      UserServiceImpl
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/2/7 11:18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
