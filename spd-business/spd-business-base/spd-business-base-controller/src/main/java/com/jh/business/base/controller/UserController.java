package com.jh.business.base.controller;

import com.jh.business.base.service.UserService;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @blame 杨赋
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录或注册(根据手机号)
     * @param user
     * @return 行数
     */
    @PostMapping("/loginOrRegister")
    public ResponseMsg loginOrRegister(@RequestBody User user){
        int row = userService.save(user);

        return ResponseMsg.success(row);
    }

    /**
     *
     */
    @GetMapping("/get")
    public ResponseMsg<User> get(User user){
        User result = userService.get(user);

        return ResponseMsg.success(result);
    }

}

