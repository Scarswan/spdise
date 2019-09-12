package com.jh.business.qingyuan.service;

import com.jh.common.model.qingyuan.Student;

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
}
