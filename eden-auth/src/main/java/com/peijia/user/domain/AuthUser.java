package com.peijia.user.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * @author Peijia
 * @className AuthUser
 * @desc 鉴权user
 * @create 2020/8/15 19:47
 */
@Data
public class AuthUser implements Serializable {

    private static final long serialVersionUID = -1364329301619409069L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;

}
