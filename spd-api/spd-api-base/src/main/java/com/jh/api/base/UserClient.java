package com.jh.api.base;

import com.github.pagehelper.PageInfo;
import com.jh.api.base.fallbackfactory.UserClientFallbackFactory;
import com.jh.common.dto.base.UserDTO;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.vo.base.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "business-base", path = "/user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    /**
     * 登录或注册(根据手机号)
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/login/register")
    ResponseMsg loginOrRegister(@RequestBody UserDTO userDTO);

    /**
     * 获取用户信息
     *
     * @return
     */
    @PostMapping("/queryUser")
    ResponseMsg<PageInfo<UserVO>> queryUser(@RequestBody UserDTO userDTO);

}
