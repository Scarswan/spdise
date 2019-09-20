package com.jh.business.qingyuan.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.qingyuan.Student;
import com.jh.common.query.qingyuan.StudentQuery;

public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询学生信息列表
     *
     * @param studentQuery
     * @return
     */
    List<Student> selectByAll(StudentQuery studentQuery);
}