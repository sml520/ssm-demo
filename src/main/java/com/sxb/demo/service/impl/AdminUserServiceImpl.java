package com.sxb.demo.service.impl;

import com.sxb.demo.dao.AdminUserDao;
import com.sxb.demo.entity.AdminUser;
import com.sxb.demo.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张元亮 on 2018/9/5.
 * @author
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService{

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public AdminUser updateTokenAndLogin(String userName, String password) {
        AdminUser adminUser = adminUserDao.getAdminUserByUserNameAndPassword(userName, password);

        return null;
    }
}
