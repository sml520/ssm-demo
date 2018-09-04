package com.sxb.demo.entity;

import java.io.Serializable;

/**
 * Created by 张元亮 on 2018/8/16.
 */
public class Student implements Serializable{

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
