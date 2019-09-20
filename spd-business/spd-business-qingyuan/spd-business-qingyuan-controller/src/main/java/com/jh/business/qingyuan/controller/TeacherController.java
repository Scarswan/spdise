package com.jh.business.qingyuan.controller;

import com.github.pagehelper.PageInfo;
import com.jh.business.qingyuan.service.TeacherService;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.query.qingyuan.TeacherQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 保存教师信息
     *
     * @param teacher
     * @return
     */
    @PostMapping("/save/info")
    public ResponseMsg saveTeacher(@RequestBody Teacher teacher) {
        int row = teacherService.saveTeacher(teacher);

        return ResponseMsg.successRow(row);
    }

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     */
    @PostMapping("/update/info")
    public ResponseMsg updateTeacher(@RequestBody Teacher teacher) {
        int row = teacherService.updateTeacher(teacher);

        return ResponseMsg.successRow(row);
    }

    /**
     * 修改登录密码
     *
     * @param teacher
     * @return
     */
    @PostMapping("/update/password")
    public ResponseMsg updatePassword(@RequestBody Teacher teacher){
        int row = teacherService.updatePassword(teacher);

        return ResponseMsg.successRow(row);
    }

    /**
     * 根据主键id查询教师信息
     *
     * @param teacherId
     * @return
     */
    @GetMapping("/query/byTeacherId")
    public ResponseMsg<Teacher> queryByTeacherId(String teacherId) {
        Teacher teacher = teacherService.queryByTeacherId(teacherId);

        return ResponseMsg.success(teacher);
    }

    /**
     * 查询教师列表分页
     *
     * @param teacherQuery
     * @return
     */
    @GetMapping("/query/list/page")
    public ResponseMsg<PageInfo<Teacher>> queryListPage(TeacherQuery teacherQuery) {
        PageInfo<Teacher> teacherPageInfo = teacherService.queryListPage(teacherQuery);

        return ResponseMsg.success(teacherPageInfo);
    }
}
