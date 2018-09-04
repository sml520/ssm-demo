package com.sxb.demo.dao;

import com.sxb.demo.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by 张元亮 on 2018/8/16.
 */
@Repository
public interface StudentDao {

    /**
     * 通过id查找学生
     * @param id
     * @return
     */
    Student findStudentById(int id);
}
