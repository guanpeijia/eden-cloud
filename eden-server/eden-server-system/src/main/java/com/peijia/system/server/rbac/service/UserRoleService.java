package com.peijia.system.server.rbac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.peijia.common.domain.UserRole;

/**
 * @author Peijia
 * @className UserRoleService
 * @desc ${description}
 * @create 2021/3/5 17:34
 */
public interface UserRoleService extends IService<UserRole> {

    boolean deleteUserRolesByRoleId(String[] roleIds);

    boolean deleteUserRolesByUserId(String[] userIds);
}
