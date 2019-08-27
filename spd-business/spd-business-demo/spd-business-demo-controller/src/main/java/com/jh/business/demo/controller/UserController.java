package com.jh.business.demo.controller;

import com.jh.business.demo.service.UserService;
import com.jh.model.base.ResponseMsg;
import com.jh.model.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangFu
 * @data 2019/08/23 18:05
 */
@RestController
@RequestMapping("/demo/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public ResponseMsg UserRegister(@RequestBody User user) {
        userService.UserRegister(user);

        return ResponseMsg.success();
    }

}
