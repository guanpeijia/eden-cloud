package com.peijia.system.server.rbac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peijia.common.domain.UserRole;
import com.peijia.system.server.rbac.mapper.UserRoleMapper;
import com.peijia.system.server.rbac.service.UserRoleService;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @className      UserRoleServiceImpl
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/3/5 17:34
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUserRolesByRoleId(String[] roleIds) {
        return Arrays.stream(roleIds).allMatch(id -> {
            Boolean hasDelete = baseMapper.deleteByRoleId(Long.valueOf(id));
            if (Boolean.FALSE.equals(hasDelete)){
                log.error("id"+id+"根据角色Id删除该角色的用户关系");
            }
            return hasDelete;
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUserRolesByUserId(String[] userIds) {
       return Arrays.stream(userIds).allMatch(id -> {
           Boolean hasDelete = baseMapper.deleteByUserId(Long.valueOf(id));
           if (Boolean.FALSE.equals(hasDelete)){
               log.error("id"+id+"根据用户Id删除该用户的角色关系");
           }
           return hasDelete;
       });
    }
}
