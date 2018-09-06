package com.sxb.demo.service.impl;

import com.sxb.demo.dao.AdminUserDao;
import com.sxb.demo.entity.AdminUser;
import com.sxb.demo.service.AdminUserService;
import com.sxb.demo.utils.MD5Util;
import com.sxb.demo.utils.NumberUtil;
import com.sxb.demo.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张元亮 on 2018/9/5.
 *
 * @author
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public AdminUser updateTokenAndLogin(String userName, String password) {
        AdminUser adminUser = adminUserDao.getAdminUserByUserNameAndPassword(userName, MD5Util.MD5Encode(password, "UTF-8"));
        if (adminUser != null) {
            // 登录后即刻执行修改token的操作
            String token = this.getNewToken(System.currentTimeMillis() + "", adminUser.getId());
            if (adminUserDao.updateUserToken(adminUser.getId(), token) > 0) {
                // 返回数据时带上token
                adminUser.setUserToken(token);
                return adminUser;
            }
        }
        return null;
    }

    /**
     * 获取token值
     *
     * @param sessionId
     * @param userId
     * @return
     */
    private String getNewToken(String sessionId, Long userId) {
        String src = sessionId + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }

    @Override
    public AdminUser getAdminUserByToken(String userToken) {
        return adminUserDao.getAdminUserByToken(userToken);
    }

    public static void main(String[] args) {
       int res =  NumberUtil.genRandomNum(4);
       System.out.print(res);
    }


}
