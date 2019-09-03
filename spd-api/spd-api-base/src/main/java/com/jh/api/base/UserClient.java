package com.jh.api.base;

import com.jh.api.base.fallbackfactory.UserClientFallbackFactory;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.model.base.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "business-base", path = "/user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    /**
     * 登录或注册(根据手机号)
     *
     * @param user
     * @return 行数
     */
    @PostMapping("/loginOrRegister")
    ResponseMsg loginOrRegister(@RequestBody User user);

    /**
     * 获取一条用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserInfo")
    ResponseMsg<User> getUserInfo(@RequestBody User user);

    /**
     * 获取全部用户信息
     *
     * @return
     */
    @GetMapping("/listUser")
    ResponseMsg<List<User>> listUser();

}
