package com.peijia.auth.service.impl;

import com.peijia.auth.manager.UserManager;
import com.peijia.common.domain.User;
import com.peijia.user.domain.AuthUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Peijia
 * @className EdenUserDetailService
 * @desc
 * @create 2020/8/15 19:56
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUsername());
            boolean notLocked = false;
            if (StringUtils.equals(User.STATUS_VALID, systemUser.getStatus()))
                notLocked = true;
            AuthUser authUser = new AuthUser(systemUser.getUsername(), systemUser.getPassword(), true, true, true, notLocked,
                AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));

            return transSystemUserToAuthUser(authUser,systemUser);
        } else {
            throw new UsernameNotFoundException("");
        }
    }

    private AuthUser transSystemUserToAuthUser(AuthUser authUser, User systemUser) {
        authUser.setAvatar(systemUser.getAvatar());
        authUser.setDeptId(systemUser.getDeptId());
        authUser.setDeptName(systemUser.getDeptName());
        authUser.setEmail(systemUser.getEmail());
        authUser.setMobile(systemUser.getMobile());
        authUser.setRoleId(systemUser.getRoleId());
        authUser.setRoleName(systemUser.getRoleName());
        authUser.setSex(systemUser.getSex());
        authUser.setUserId(systemUser.getUserId());
        authUser.setLastLoginTime(systemUser.getLastLoginTime());
        authUser.setDescription(systemUser.getDescription());
        authUser.setStatus(systemUser.getStatus());
        return authUser;
    }
}
