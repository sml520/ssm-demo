package com.sxb.demo.service;

import com.sxb.demo.entity.AdminUser;

/**
 * Created by 张元亮 on 2018/9/5.
 */
public interface AdminUserService {

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    AdminUser updateTokenAndLogin(String userName, String password);
}
