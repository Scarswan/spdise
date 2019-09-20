package com.jh.api.qingyuan.fallbackfactory;

import com.github.pagehelper.PageInfo;
import com.jh.api.qingyuan.TeacherClient;
import com.jh.common.enums.RetCode;
import com.jh.common.model.qingyuan.Teacher;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.query.qingyuan.TeacherQuery;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TeacherClientFallbackFactory implements FallbackFactory<TeacherClient> {
    private static Logger logger = LoggerFactory.getLogger(TeacherClientFallbackFactory.class);

    @Override
    public TeacherClient create(Throwable throwable) {
        logger.error("QingYuan服务调用失败", throwable);
        return new TeacherClient() {
            @Override
            public ResponseMsg saveTeacher(Teacher teacher) {
                return ResponseMsg.error(RetCode.CODE_999903, throwable.getMessage());
            }

            @Override
            public ResponseMsg updateTeacher(Teacher teacher) {
                return ResponseMsg.error(RetCode.CODE_999903, throwable.getMessage());
            }

            @Override
            public ResponseMsg<PageInfo<Teacher>> queryList(TeacherQuery teacherQuery) {
                return ResponseMsg.error(RetCode.CODE_999903, throwable.getMessage());
            }
        };
    }
}
