package com.jh.business.demo.controller;

import com.jh.api.base.UserClient;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.model.base.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinController {

    private Logger logger = LoggerFactory.getLogger(ZipkinController.class);

    @Autowired
    private UserClient userClient;

//    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
//    public ResponseMsg<User> getUserInfo(@RequestBody User user) {
//        logger.info("getUserInfo：调用 Api-Base 查询一条 user 信息，user = {}", user);
//        return userClient(user);
//    }

}
