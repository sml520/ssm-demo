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

    /**
     * 根据id获取用户记录
     *
     * @return
     */
    AdminUser selectById(Long id);

    /**
     * 根据用户名获取用户记录
     *
     * @return
     */
    AdminUser selectByUserName(String userName);

    /**
     * 新增用户记录
     *
     * @return
     */
    int save(AdminUser user);

    /**
     * 修改密码
     *
     * @return
     */
    int updatePassword(AdminUser user);
}
