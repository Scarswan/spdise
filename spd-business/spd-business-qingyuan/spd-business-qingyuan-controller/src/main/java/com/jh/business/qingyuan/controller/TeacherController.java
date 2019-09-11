package com.jh.business.qingyuan.controller;

import com.jh.business.qingyuan.service.TeacherService;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/save")
    public ResponseMsg saveTeacher(@RequestBody Teacher teacher){
        int row = teacherService.saveTeacher(teacher);
        return ResponseMsg.successRow(row);
    }

}
