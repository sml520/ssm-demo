package com.sxb.demo.service.impl;

import com.sxb.demo.dao.StudentDao;
import com.sxb.demo.entity.Student;
import com.sxb.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张元亮 on 2018/8/16.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findStudentById(int id) {
        return studentDao.findStudentById(id);
    }
}
