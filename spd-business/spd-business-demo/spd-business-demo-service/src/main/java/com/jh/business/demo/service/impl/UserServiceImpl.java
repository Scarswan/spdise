package com.jh.business.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.business.demo.mapper.UserMapper;
import com.jh.business.demo.service.UserService;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.PasswordUtil;
import com.jh.common.util.sequence.Sequence;
import com.jh.common.model.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Deprecated
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

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
