package com.peijia.system.server.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peijia.common.domain.User;
import com.peijia.common.domain.UserRole;
import com.peijia.common.entity.QueryRequest;
import com.peijia.common.exception.BusinessException;
import com.peijia.system.server.rbac.mapper.UserMapper;
import com.peijia.system.server.rbac.service.UserRoleService;
import com.peijia.system.server.rbac.service.UserService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @className      UserServiceImpl
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/2/7 11:18
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public IPage<User> findUserDetail(User user, QueryRequest request) {
        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.baseMapper.findUserDetailPage(page, user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createUser(User user) {
        boolean hasSave = false;
        // 创建用户
        user.setCreateTime(new Date());
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(passwordEncoder.encode(User.DEFAULT_PASSWORD));
        boolean hasSaveUser = save(user);
        if (hasSaveUser){
            // 保存用户角色
            String[] roles = user.getRoleId().split(StringPool.COMMA);
            hasSave = setUserRoles(user, roles);
            if (!hasSave){
                throw new BusinessException(user.getRoleId()+"保存用户角色失败");
            }
        }
        return hasSave;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
        // 更新用户
        user.setPassword(null);
        user.setUsername(null);
        user.setCreateTime(null);
        user.setModifyTime(new Date());
        boolean hasUpdateUser = updateById(user);
        if (hasUpdateUser){
            boolean hasRemoveUserRole = userRoleService.remove(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, user.getUserId()));
            if (!hasRemoveUserRole){
                throw new BusinessException(user.getUserId()+"删除用户角色失败");
            }
            String[] roles = user.getRoleId().split(StringPool.COMMA);
            boolean hasSetUserRoles = setUserRoles(user, roles);
            if (!hasSetUserRoles){
                throw new BusinessException(user.getUserId()+"设置用户角色失败");
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUsers(String[] userIds) {
        List<String> list = Arrays.asList(userIds);
        removeByIds(list);
        // 删除用户角色
        boolean hasDelete = userRoleService.deleteUserRolesByUserId(userIds);
        if (!hasDelete){
            throw new BusinessException("删除用户角色失败");
        }
        return true;
    }

    private boolean setUserRoles(User user, String[] roles) {
       return Arrays.stream(roles).allMatch(roleId -> {
            UserRole ur = new UserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(Long.valueOf(roleId));
           boolean save = userRoleService.save(ur);
           if (!save) {
               log.error("roleId:"+roleId+"报错失败");
           }
           return save;
       });
    }
}
