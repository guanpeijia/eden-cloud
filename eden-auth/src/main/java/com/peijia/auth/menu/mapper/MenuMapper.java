package com.peijia.auth.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peijia.auth.menu.domain.Menu;
import java.util.List;

/**
 * @className      MenuMapper
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/2/7 11:20
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findUserPermissions(String userName);
}