package com.sxb.demo.dao;

import com.sxb.demo.entity.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 张元亮 on 2018/9/5.
 */
@Repository
public interface AdminUserDao {

    /**
     * 根据登录名和密码获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserByUserNameAndPassword(@Param("userName") String userName, @Param("passwordMD5") String passwordMD5);

    /**
     * 根据userToken获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserByToken(String userToken);

    /**
     * 更新用户token值
     *
     * @param userId
     * @param newToken
     * @return
     */
    int updateUserToken(@Param("userId") Long userId, @Param("newToken") String newToken);


}
