package com.jh.business.base.controller;

import com.alibaba.fastjson.JSON;
import com.jh.business.base.service.UserService;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.base.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @blame 杨赋
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 登录或注册(根据手机号)
     *
     * @param user
     * @return 行数
     */
    @PostMapping("/loginOrRegister")
    public ResponseMsg loginOrRegister(@RequestBody User user) {
        int row = userService.save(user);

        return ResponseMsg.success(row);
    }

    /**
     * 获取一条用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserInfo")
    public ResponseMsg<User> get(@RequestBody User user) {
        log.info("获取一条user信息，参数：" + JSON.toJSONString(user));

        User result = userService.get(user);

        return ResponseMsg.success(result);
    }

}

