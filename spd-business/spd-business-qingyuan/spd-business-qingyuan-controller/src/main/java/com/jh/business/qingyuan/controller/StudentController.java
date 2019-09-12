package com.jh.business.qingyuan.controller;

import com.jh.business.qingyuan.service.StudentService;
import com.jh.common.model.qingyuan.Student;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 保存学生信息
     *
     * @param student
     * @return
     */
    @PostMapping("/save/info")
    public ResponseMsg saveStudent(@RequestBody Student student) {
        int row = studentService.saveStudent(student);

        return ResponseMsg.successRow(row);
    }
}
