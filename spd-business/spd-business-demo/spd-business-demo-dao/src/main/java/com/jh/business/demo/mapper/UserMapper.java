package com.jh.business.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.User;

public interface UserMapper extends BaseMapper<User> {

    int insert(User user);

}
