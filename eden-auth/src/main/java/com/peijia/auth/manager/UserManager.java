package com.peijia.auth.manager;

import com.peijia.auth.menu.domain.Menu;
import com.peijia.auth.menu.mapper.MenuMapper;
import com.peijia.common.domain.User;
import com.peijia.auth.user.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Peijia
 * @className UserManager
 * @desc
 * @create 2021/2/7 17:22
 */
@Service
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
