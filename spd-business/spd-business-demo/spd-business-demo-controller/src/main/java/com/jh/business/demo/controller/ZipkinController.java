package com.jh.business.demo.controller;

import com.alibaba.fastjson.JSON;
import com.jh.api.base.UserClient;
import com.jh.common.model.base.ResponseMsg;
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

    private Logger log = LoggerFactory.getLogger(ZipkinController.class);

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseMsg<User> get(@RequestBody User user) {
        log.info("调用 userClient 获取一条user信息 参数：" + JSON.toJSONString(user));
        return userClient.getUserInfo(user);
    }

}
