package com.jh.business.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jh.business.base.mapper.UserMapper;
import com.jh.business.base.service.UserService;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.exception.BizException;
import com.jh.common.model.base.User;
import com.jh.common.util.PasswordUtil;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @blame 杨赋
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public int save(User user) {
        user.setUserId(Sequence.generateBaseId());
        user.setIsDelete(YesNoEnum.NO_CODE.getCode());
        user.setUserPassword(PasswordUtil.getMD5Password(user.getUserPassword()));
        user.setCreateTime(DateUtil.getCurrentTimeString());
        user.setUpdateTime(DateUtil.getCurrentTimeString());
        logger.info("save：保存一条用户信息，入参: user = {}", user);
        int row = userMapper.insert(user);
        logger.info("save：保存一条用户信息成功，返参: row = {}", row);

        return row;
    }

    @Override
    public int batchSave(List<User> userList) {
        logger.info("batchSave：批量新增用户信息，入参: userList = {}", userList);

        int rows = 0;
        for (User user : userList) {
            user.setUserId(Sequence.generateBaseId());
            user.setIsDelete(YesNoEnum.NO_CODE.getCode());
            user.setUserPassword(PasswordUtil.getMD5Password(user.getUserPassword()));
            user.setCreateTime(DateUtil.getCurrentTimeString());
            user.setUpdateTime(DateUtil.getCurrentTimeString());
        }
        rows = userMapper.insertList(userList);
        logger.info("batchSave：批量新增用户信息成功，返参: rows = {}", rows);

        return rows;
    }

    @Override
    public User getUserInfo(User user) {
        logger.info("getUserInfo：获取一条user信息，入参: user = {}", user);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(user.getUserId())) {
            queryWrapper.eq(User.COL_USER_ID, user.getUserId());
        }
        queryWrapper.like(User.COL_USER_NAME, user.getUserName());
        if (StringUtils.isNotBlank(user.getUserPhone())) {
            queryWrapper.eq(User.COL_USER_PHONE, user.getUserPhone());
        }
        if (StringUtils.isNotBlank(user.getCreateTime())) {
            queryWrapper.lt(User.COL_CREATE_TIME, "STR_TO_DATE(CONCAT(" + user.getCreateTime() + ",':00'),'%Y-%m-%d %H:%i:%s')");
        }

        User queryUser = userMapper.selectOne(queryWrapper);
        logger.info("getUserInfo：获取一条user信息成功，返参: queryUser = {}", queryUser);

        return queryUser;
    }

    @Override
    public List<User> listUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(queryWrapper);
        logger.info("listUser：获取全部user信息成功，返参: userList = {}", userList);

        return userList;
    }

    @Override
    public int updateUser(User user) {
        if (StringUtils.isBlank(user.getUserId())) {
            throw new BizException("updateUser:更新用户信息,userId不能为空");
        }
        user.setUpdateTime(DateUtil.getCurrentTimeString());
        logger.info("listUser：更新一条user信息，入参: user = {}", user);
        int row = userMapper.updateByUserId(user, user.getUserId());
        logger.info("listUser：更新一条user信息成功，返参: row = {}", row);

        return row;
    }
}
