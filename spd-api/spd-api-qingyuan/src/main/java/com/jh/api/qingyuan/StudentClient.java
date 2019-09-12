package com.jh.api.qingyuan;

import com.jh.api.qingyuan.fallbackfactory.StudentClientFallbackFactory;
import com.jh.common.model.qingyuan.Student;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "business-qingyuan", fallbackFactory = StudentClientFallbackFactory.class)
public interface StudentClient {
    /**
     * 保存学生信息
     *
     * @param student
     * @return
     */
    @PostMapping("/save/info")
    ResponseMsg saveStudent(@RequestBody Student student);
}
