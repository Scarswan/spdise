package com.jh.api.demo;

import com.jh.api.demo.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "business-demo",fallback = UserClientFallBack.class)
public interface UserClient {
}
