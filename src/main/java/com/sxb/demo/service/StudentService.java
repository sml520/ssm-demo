package com.sxb.demo.service;

import com.sxb.demo.entity.Student;

/**
 * Created by 张元亮 on 2018/8/16.
 */
public interface StudentService {

    /**
     * 通过id查找学生
     * @param id
     * @return
     */
    Student findStudentById(int id);
}
