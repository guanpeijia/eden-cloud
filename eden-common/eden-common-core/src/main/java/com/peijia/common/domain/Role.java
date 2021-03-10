package com.peijia.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @className      Role
 * @author     Peijia
 * @desc  角色表
 * @create    2021/3/5 17:24
 */
@Data
@TableName(value = "t_role")
public class Role {
    /**
     * 角色ID
     */
    @TableId(value = "ROLE_ID", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField(value = "ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @TableField(value = "REMARK")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "MODIFY_TIME")
    private Date modifyTime;
}