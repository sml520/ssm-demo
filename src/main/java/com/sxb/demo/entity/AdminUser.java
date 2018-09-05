package com.sxb.demo.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by 张元亮 on 2018/9/5.
 * @author zyl
 */
public class AdminUser implements Serializable{

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * token值
     */
    private String userToken;

    /**
     * 是否已删除 0未删除 1已删除
     */
    private int isDeleted;

    /**
     * 添加时间
     */
    private Date createTime;

}
