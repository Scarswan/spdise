package com.jh.business.base.controller;

import com.jh.business.base.service.UserService;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.model.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 批量增添用户
     *
     * @param userList
     * @return
     */
    @PostMapping("/batchSave")
    public ResponseMsg batchSave(@RequestBody List<User> userList) {
        int rows = userService.batchSave(userList);

        return ResponseMsg.success("rows: " + rows);
    }


    /**
     * 获取一条用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserInfo")
    public ResponseMsg<User> getUserInfo(@RequestBody User user) {
        User result = userService.getUserInfo(user);

        return ResponseMsg.success(result);
    }

    /**
     * 获取全部用户信息
     *
     * @return
     */
    @GetMapping("/listUser")
    public ResponseMsg<List<User>> listUser() {
        List<User> userList = userService.listUser();

        return ResponseMsg.success(userList);
    }

    /**
     * 更新一条用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public ResponseMsg updateUser(@RequestBody User user) {
        int row = userService.updateUser(user);

        return ResponseMsg.success("row: " + row);
    }

}

