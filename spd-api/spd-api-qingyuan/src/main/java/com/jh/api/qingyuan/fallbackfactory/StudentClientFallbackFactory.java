package com.jh.api.qingyuan.fallbackfactory;

import com.jh.api.qingyuan.StudentClient;
import com.jh.common.enums.RetCode;
import com.jh.common.model.qingyuan.Student;
import com.jh.common.model.response.ResponseMsg;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentClientFallbackFactory implements FallbackFactory<StudentClient> {
    private static Logger logger = LoggerFactory.getLogger(StudentClientFallbackFactory.class);

    @Override
    public StudentClient create(Throwable throwable) {
        logger.error("QingYuan服务调用失败", throwable);
        return new StudentClient() {
            @Override
            public ResponseMsg saveStudent(Student student) {
                return ResponseMsg.error(RetCode.CODE_999903, throwable.getMessage());
            }
        };
    }
}
