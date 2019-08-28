package com.jh.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.business.base.mapper.UserMapper;
import com.jh.business.service.UserService;
import com.jh.common.model.base.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
