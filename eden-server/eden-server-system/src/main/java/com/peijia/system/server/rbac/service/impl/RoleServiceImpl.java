package com.peijia.system.server.rbac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peijia.common.domain.Role;
import com.peijia.system.server.rbac.mapper.RoleMapper;
import com.peijia.system.server.rbac.service.RoleService;
import org.springframework.stereotype.Service;
/**
 * @className      roleServiceImpl
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/3/5 17:23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
