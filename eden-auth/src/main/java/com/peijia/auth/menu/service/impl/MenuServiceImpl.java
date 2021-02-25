package com.peijia.auth.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peijia.auth.menu.domain.Menu;
import com.peijia.auth.menu.mapper.MenuMapper;
import com.peijia.auth.menu.service.MenuService;
import org.springframework.stereotype.Service;
/**
 * @className      MenuServiceImpl
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/2/7 11:20
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{

}
