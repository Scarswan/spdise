package com.jh.business.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jh.business.base.mapper.UserMapper;
import com.jh.business.base.service.UserService;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.model.base.User;
import com.jh.common.util.PasswordUtil;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @blame 杨赋
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int save(User user) {
        // 查询是否已存在
        User queryUser = get(user);

        int row = 0;
        if (queryUser == null) {
            user.setUserId(Sequence.createId());
            user.setIsDelete(YesNoEnum.NO_CODE.getCode());
            user.setUserPassword(PasswordUtil.getMD5Password(user.getUserPassword()));
            user.setCreateTime(DateUtil.getCurrentTime());
            user.setCreateTime(DateUtil.getCurrentTime());
            row = userMapper.insert(user);
        }

        return row;
    }

    @Override
    public User get(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(user.getUserId())) {
            queryWrapper.eq(User.COL_USER_ID, user.getUserId());
        }
        queryWrapper.like(User.COL_USER_NAME, user.getUserName());
        if (StringUtils.isNotBlank(user.getUserPhone())) {
            queryWrapper.eq(User.COL_USER_PHONE, user.getUserPhone());
        }
        if (StringUtils.isNotBlank(user.getCreateTime())) {
            queryWrapper.lt(User.COL_CREATE_TIME, user.getCreateTime());
        }

        User queryUser = userMapper.selectOne(queryWrapper);

        return queryUser;
    }
}
