package com.jh.business.qingyuan.controller;

import com.github.pagehelper.PageInfo;
import com.jh.business.qingyuan.service.StudentService;
import com.jh.common.model.qingyuan.Student;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.query.qingyuan.StudentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据主键id查询学生信息
     *
     * @param studentId
     * @return
     */
    @GetMapping("/query/byStudentId")
    public ResponseMsg<Student> queryByStudentId(String studentId) {
        Student student = studentService.queryByStudentId(studentId);

        return ResponseMsg.success(student);
    }

    /**
     * 查询学生列表分页
     *
     * @param studentQuery
     * @return
     */
    @GetMapping("/query/list/page")
    public ResponseMsg<PageInfo<Student>> queryListPage(StudentQuery studentQuery) {
        PageInfo<Student> studentPageInfo = studentService.queryListPage(studentQuery);

        return ResponseMsg.success(studentPageInfo);
    }
}
