package com.jh.business.qingyuan.service.impl;

import com.jh.business.qingyuan.mapper.TeacherMapper;
import com.jh.business.qingyuan.service.TeacherService;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}


