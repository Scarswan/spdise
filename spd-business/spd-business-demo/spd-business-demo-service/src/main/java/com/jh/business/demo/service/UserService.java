package com.jh.business.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jh.common.model.base.User;

public interface UserService extends IService<User> {

    void UserRegister(User user);

}
