package com.sxb.demo.service;

import com.sxb.demo.entity.AdminUser;
import com.sxb.demo.utils.PageResult;
import com.sxb.demo.utils.PageUtil;

/**
 * Created by 张元亮 on 2018/9/5.
 */
public interface AdminUserService {

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    AdminUser updateTokenAndLogin(String userName, String password);

    /**
     * 根据userToken获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserByToken(String userToken);

    PageResult getAdminUserPage(PageUtil pageUtil);
}
