package com.jh.business.qingyuan.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.query.qingyuan.TeacherQuery;

public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * 根据主键id更新教师信息
     *
     * @param updated
     * @return
     */
    int updateByTeacherId(@Param("updated") Teacher updated);

    /**
     * 查询教师信息列表
     *
     * @param teacher
     * @return
     */
    List<Teacher> selectByAll(TeacherQuery teacher);
}