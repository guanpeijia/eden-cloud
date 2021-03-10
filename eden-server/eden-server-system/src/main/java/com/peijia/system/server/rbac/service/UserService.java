package com.peijia.system.server.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peijia.common.entity.QueryRequest;
import com.peijia.common.domain.User;
    /**
 * @className      UserService
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/2/7 11:18
 */
public interface UserService extends IService<User>{

        /**
         * 查找用户详细信息
         *
         * @param request request
         * @param user    用户对象，用于传递查询条件
         * @return IPage
         */
        IPage<User> findUserDetail(User user, QueryRequest request);

        /**
         * 新增用户
         *
         * @param user user
         */
        boolean createUser(User user);

        /**
         * 修改用户
         *
         * @param user user
         */
        boolean updateUser(User user);

        /**
         * 删除用户
         *
         * @param userIds 用户 id数组
         */
        boolean deleteUsers(String[] userIds);
}
