package com.peijia.system.server.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peijia.common.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @className      UserMapper
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/2/7 11:18
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param user 用户对象，用于传递查询条件
     * @return Ipage
     */
    Page<User> findUserDetailPage(Page page, @Param("user") User user);
}