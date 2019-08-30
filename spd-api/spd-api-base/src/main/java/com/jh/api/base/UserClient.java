package com.jh.api.base;

import com.jh.api.base.fallback.UserClientFallbackFactory;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.base.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "business-base",path = "/user",fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    /**
     * 获取一条用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserInfo")
    ResponseMsg<User> get(@RequestBody User user);

}
