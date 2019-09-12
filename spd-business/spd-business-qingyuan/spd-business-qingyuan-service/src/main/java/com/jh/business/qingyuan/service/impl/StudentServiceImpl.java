package com.jh.business.qingyuan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.business.qingyuan.mapper.StudentMapper;
import com.jh.business.qingyuan.service.StudentService;
import com.jh.common.constants.PasswordConstants;
import com.jh.common.model.qingyuan.Student;
import com.jh.common.query.qingyuan.StudentQuery;
import com.jh.common.util.PasswordUtil;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int saveStudent(Student student) {
        student.setStudentId(Sequence.generateQingYuanId());
        student.setStudentPassword(PasswordUtil.getMD5Password(PasswordConstants.DEFAULT_PWD));
        student.setCreateTime(DateUtil.getCurrentTimeString());
        logger.info("saveStudent: 保存学生信息, 入参: student = {}", student);
        int row = studentMapper.insert(student);
        logger.info("saveStudent: 保存学生信息成功, 出参: row = {}", row);

        return row;
    }

    @Override
    public Student queryByStudentId(String studentId) {
        logger.info("queryByStudentId: 根据主键id查询学生信息, 入参：studentId = {}", studentId);
        Student student = studentMapper.selectById(studentId);
        logger.info("queryByStudentId: 根据主键id查询学生信息成功, 入参：student = {}", student);

        return student;
    }

    @Override
    public PageInfo<Student> queryListPage(StudentQuery studentQuery) {
        logger.info("queryList: 查询学生列表分页, 入参: studentQuery = {}", studentQuery);
        List<Student> studentList = studentMapper.selectByAll(studentQuery);
        PageHelper.startPage(studentQuery.getPageNum(), studentQuery.getPageSize());
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList);
        logger.info("queryList: 查询学生列表分页成功, 出参: studentPageInfo = {}", studentPageInfo);

        return studentPageInfo;
    }
}
