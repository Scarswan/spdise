package com.jh.business.qingyuan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.business.qingyuan.mapper.TeacherMapper;
import com.jh.business.qingyuan.service.TeacherService;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.query.qingyuan.TeacherQuery;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int saveTeacher(Teacher teacher) {
        teacher.setTeacherId(Sequence.generateQingYuanId());
        teacher.setCreateTime(DateUtil.getCurrentTimeString());
        logger.info("saveTeacher: 保存教师信息, 入参: teacher = {}", teacher);
        int row = teacherMapper.insert(teacher);
        logger.info("saveTeacher: 保存教师信息成功, 出参: row = {}", row);

        return row;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        teacher.setUpdateTime(DateUtil.getCurrentTimeString());
        logger.info("updateTeacher: 更新教师信息, 入参：teacher = {}", teacher);
        int row = teacherMapper.updateByTeacherId(teacher);
        logger.info("updateTeacher: 更新教师信息成功, 出参: row = {}", row);

        return row;
    }

    @Override
    public Teacher getByTeacherId(String teacherId) {
        logger.info("getByTeacherId: 根据主键id查询指定教师信息, 入参：teacherId = {}", teacherId);
        Teacher teacher = teacherMapper.selectById(teacherId);
        logger.info("getByTeacherId: 根据主键id查询指定教师信息成功, 入参：teacher = {}", teacher);

        return teacher;
    }

    @Override
    public PageInfo<Teacher> queryList(TeacherQuery teacherQuery) {
        logger.info("queryList: 查询教师信息分页, 入参: teacherQuery = {}", teacherQuery);
        List<Teacher> teacherList = teacherMapper.selectByAll(teacherQuery);
        PageHelper.startPage(teacherQuery.getPageNum(), teacherQuery.getPageSize());
        PageInfo<Teacher> teacherPageInfo = new PageInfo<>(teacherList);
        logger.info("queryList: 查询教师信息分页成功, 出参: teacherPageInfo = {}", teacherPageInfo);

        return teacherPageInfo;
    }
}


