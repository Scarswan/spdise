package com.jh.business.qingyuan.service.impl;

import com.jh.business.qingyuan.mapper.TeacherMapper;
import com.jh.business.qingyuan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

}
