package com.jh.api.qingyuan;

import com.jh.api.qingyuan.fallbackfactory.ClazzClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "business-qingyuan", fallbackFactory = ClazzClientFallbackFactory.class)
public interface ClazzClient {
}
