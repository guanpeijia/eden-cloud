package com.peijia.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @className      UserRole
 * @author     Peijia
 * @desc  ${description}  
 * @create    2021/3/5 17:34
 */
/**
    * 用户角色关联表
    */
@Data
@TableName(value = "t_user_role")
public class UserRole {
    /**
     * 用户ID
     */
    @TableField(value = "USER_ID")
    private Long userId;

    /**
     * 角色ID
     */
    @TableField(value = "ROLE_ID")
    private Long roleId;
}