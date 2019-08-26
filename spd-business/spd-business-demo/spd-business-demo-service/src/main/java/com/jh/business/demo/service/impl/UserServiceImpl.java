package com.jh.business.demo.service.impl;

import com.jh.business.demo.mapper.UserMapper;
import com.jh.business.demo.service.UserService;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.date.PasswordUtil;
import com.jh.common.util.date.sequence.Sequence;
import com.jh.model.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void UserRegister(User user) {
        user.setUserId(Sequence.createId());
        user.setUserPassword(PasswordUtil.getMD5Password(user.getUserPassword()));
        user.setIsDelete(YesNoEnum.NO_CODE.getCode());
        user.setCreateTime(DateUtil.getCurrentTime());
        user.setUpdateTime(DateUtil.getCurrentTime());

        userMapper.insert(user);
    }
}
