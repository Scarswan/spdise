package com.jh.business.qingyuan.service;

import com.github.pagehelper.PageInfo;
import com.jh.common.model.qingyuan.Student;
import com.jh.common.query.qingyuan.StudentQuery;

public interface StudentService {

    /**
     * 保存学生信息
     *
     * @param student
     * @return
     */
    int saveStudent(Student student);

    /**
     * 根据主键id查询学生信息
     *
     * @param studentId
     * @return
     */
    Student queryByStudentId(String studentId);


    /**
     * 查询学生列表分页
     *
     * @param studentQuery
     * @return
     */
    PageInfo<Student> queryListPage(StudentQuery studentQuery);
}
