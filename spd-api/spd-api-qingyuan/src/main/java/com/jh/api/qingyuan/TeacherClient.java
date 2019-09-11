package com.jh.api.qingyuan;

import com.jh.api.qingyuan.fallbackfactory.TeacherClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "business-qingyuan", fallbackFactory = TeacherClientFallbackFactory.class)
public interface TeacherClient {
}
