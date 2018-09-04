package com.sxb.demo.controller;

import com.sxb.demo.entity.Student;
import com.sxb.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张元亮 on 2018/8/16.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/infoByMV")
    public ModelAndView infoByMV() {

        Student student = studentService.findStudentById(1);
        Map<String, Object> model = new HashMap<>();
        model.put("student", student);

        return new ModelAndView("student", model);
    }

    @RequestMapping("/infoByRequest")
    public String infoByRequest(HttpServletRequest request) {

        Student student = studentService.findStudentById(1);

        request.setAttribute("student", student);

        return "student";
    }

}
