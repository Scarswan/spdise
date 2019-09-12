package com.jh.business.qingyuan.service;

import com.github.pagehelper.PageInfo;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.query.qingyuan.TeacherQuery;

public interface TeacherService {

    /**
     * 保存教师信息
     *
     * @param teacher
     * @return
     */
    int saveTeacher(Teacher teacher);

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 修改登录密码
     *
     * @param teacher
     * @return
     */
    int updatePassword(Teacher teacher);

    /**
     * 根据主键id查询教师信息
     *
     * @param teacherId
     * @return
     */
    Teacher queryByTeacherId(String teacherId);

    /**
     * 查询教师列表分页
     *
     * @param teacherQuery
     * @return
     */
    PageInfo<Teacher> queryList(TeacherQuery teacherQuery);

}


