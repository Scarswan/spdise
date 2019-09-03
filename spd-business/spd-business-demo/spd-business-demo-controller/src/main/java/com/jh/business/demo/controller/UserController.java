package com.jh.business.demo.controller;

import com.jh.business.demo.service.UserService;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.model.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YangFu
 * @data 2019/08/23 18:05
 */
@RestController
@RequestMapping("/demo/user")
@Deprecated
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public ResponseMsg UserRegister(@RequestBody User user) {
        userService.UserRegister(user);

        return ResponseMsg.success();
    }

    @RequestMapping("/query/list")
    public ResponseMsg<List<User>> list(){
        List<User> userList = userService.list();

        return ResponseMsg.success(userList);
    }

}
