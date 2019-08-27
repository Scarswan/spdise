package com.jh.api.base;

import com.jh.api.base.fallback.ClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "business-base",fallback = ClientFallBack.class)
public interface Client {
}
