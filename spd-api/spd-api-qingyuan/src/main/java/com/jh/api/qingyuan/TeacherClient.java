package com.jh.api.qingyuan;

import com.github.pagehelper.PageInfo;
import com.jh.api.qingyuan.fallbackfactory.TeacherClientFallbackFactory;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.query.qingyuan.TeacherQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "business-qingyuan", fallbackFactory = TeacherClientFallbackFactory.class)
public interface TeacherClient {
    /**
     * 保存教师信息
     *
     * @param teacher
     * @return
     */
    @PostMapping("/save/info")
    ResponseMsg saveTeacher(@RequestBody Teacher teacher);

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     */
    @PostMapping("/update/info")
    ResponseMsg updateTeacher(@RequestBody Teacher teacher);

    /**
     * 查询教师列表分页
     *
     * @param teacherQuery
     * @return
     */
    @GetMapping("/query/list/page")
    ResponseMsg<PageInfo<Teacher>> queryList(TeacherQuery teacherQuery);
}
