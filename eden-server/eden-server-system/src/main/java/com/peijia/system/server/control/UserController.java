package com.peijia.system.server.control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.peijia.common.base.BaseResponse;
import com.peijia.common.domain.User;
import com.peijia.common.entity.QueryRequest;
import com.peijia.system.server.rbac.service.UserService;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peijia
 * @className UserController
 * @desc
 * @create 2021/3/8 16:56
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user:view')")
    public BaseResponse<IPage<User>> userList(QueryRequest queryRequest, User user) {
        IPage<User> userDetail = userService.findUserDetail(user, queryRequest);
        return BaseResponse.success(userDetail);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public BaseResponse<String> addUser(@Valid User user){
        try {
            boolean hasSave = userService.createUser(user);
            if (hasSave){
                return BaseResponse.success();
            }
            return BaseResponse.error("保存用户失败");
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            return BaseResponse.error("保存用户发生异常");
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    public BaseResponse<String> updateUser(@Valid User user) {
        try {
            boolean hasUpdate = userService.updateUser(user);
            if (hasUpdate){
                return BaseResponse.success();
            }
            return BaseResponse.error("更新用户失败");
        } catch (Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            return BaseResponse.error("更新用户发生异常");
        }
    }

    @DeleteMapping("/{userIds}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public BaseResponse<String> deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            boolean hasDelete = userService.deleteUsers(ids);
            if (hasDelete){
                return BaseResponse.success();
            }
            return BaseResponse.error("删除用户失败");
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            return BaseResponse.error("删除用户发生异常");
        }
    }
}
