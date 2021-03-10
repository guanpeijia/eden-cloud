package com.peijia.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.peijia.common.validator.constraints.Mobile;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @className      User
 * @author     Peijia
 * @desc   用户表
 * @create    2021/2/7 11:18
 */
@Data
@TableName(value = "t_user")
public class User {
    /**
     * 用户ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "USERNAME")
    @Size(min = 4, max = 10, message = "{range}")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "PASSWORD")
    private String password;

    /**
     * 部门ID
     */
    @TableField(value = "DEPT_ID")
    private Long deptId;

    /**
     * 邮箱
     */
    @TableField(value = "EMAIL")
    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    private String email;

    /**
     * 联系电话
     */
    @TableField(value = "MOBILE")
    @Mobile(message = "{mobile}")
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    @TableField(value = "STATUS")
    private String status;

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

    /**
     * 最近访问时间
     */
    @TableField(value = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /**
     * 性别 0男 1女 2保密
     */
    @TableField(value = "SEX")
    private String sex;

    /**
     * 头像
     */
    @TableField(value = "AVATAR")
    private String avatar;

    /**
     * 描述
     */
    @TableField(value = "DESCRIPTION")
    private String description;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String createTimeFrom;

    @TableField(exist = false)
    private String createTimeTo;

    /**
     * 角色 ID
     */
    @TableField(exist = false)
    private String roleId;

    @TableField(exist = false)
    private String roleName;

    public static final String COL_USER_ID = "USER_ID";

    public static final String COL_USERNAME = "USERNAME";

    public static final String COL_PASSWORD = "PASSWORD";

    public static final String COL_DEPT_ID = "DEPT_ID";

    public static final String COL_EMAIL = "EMAIL";

    public static final String COL_MOBILE = "MOBILE";

    public static final String COL_STATUS = "STATUS";

    public static final String COL_CREATE_TIME = "CREATE_TIME";

    public static final String COL_MODIFY_TIME = "MODIFY_TIME";

    public static final String COL_LAST_LOGIN_TIME = "LAST_LOGIN_TIME";

    public static final String COL_SEX = "SEX";

    public static final String COL_AVATAR = "AVATAR";

    public static final String COL_DESCRIPTION = "DESCRIPTION";

    /**
     * 用户状态：有效
     */
    public static final String STATUS_VALID = "1";

    /**
     * 用户状态：锁定
     */
    public static final String STATUS_LOCK = "0";

    /**
     * 默认头像
     */
    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "1234qwer";

    /**
     * 性别男
     */
    public static final String SEX_MALE = "0";

    /**
     * 性别女
     */
    public static final String SEX_FEMALE = "1";

    /**
     * 性别保密
     */
    public static final String SEX_UNKNOW = "2";

}