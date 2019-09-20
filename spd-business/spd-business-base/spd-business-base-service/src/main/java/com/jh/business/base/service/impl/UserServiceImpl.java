package com.jh.business.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.business.base.mapper.UserMapper;
import com.jh.business.base.service.UserService;
import com.jh.common.dto.base.UserDTO;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.exception.BizException;
import com.jh.common.model.base.User;
import com.jh.common.query.base.UserQuery;
import com.jh.common.util.PasswordUtil;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import com.jh.common.vo.base.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public int save(UserDTO userDTO) {
        userDTO.setUserId(Sequence.generateBaseId());
        userDTO.setIsDelete(YesNoEnum.NO_CODE.getCode());
        userDTO.setUserPassword(PasswordUtil.getMD5Password(userDTO.getUserPassword()));
        userDTO.setCreateTime(DateUtil.getCurrentTimeString());
        userDTO.setUpdateTime(DateUtil.getCurrentTimeString());
        logger.info("save：保存一条用户信息，入参: userDTO = {}", userDTO);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        int row = userMapper.insert(user);
        logger.info("save：保存一条用户信息成功，出参: row = {}", row);

        return row;
    }

    @Override
    public int batchSave(List<UserDTO> userDTOList) {
        logger.info("batchSave：批量新增用户信息，入参: userDTOList = {}", userDTOList);
        List<User> userList = JSON.parseArray(JSON.toJSONString(userDTOList), User.class);
        for (User user : userList) {
            user.setUserId(Sequence.generateBaseId());
            user.setIsDelete(YesNoEnum.NO_CODE.getCode());
            user.setUserPassword(PasswordUtil.getMD5Password(user.getUserPassword()));
            user.setCreateTime(DateUtil.getCurrentTimeString());
            user.setUpdateTime(DateUtil.getCurrentTimeString());
        }
        int rows = userMapper.insertList(userList);
        logger.info("batchSave：批量新增用户信息成功，出参: rows = {}", rows);

        return rows;
    }

    @Override
    public PageInfo<UserVO> queryUser(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        User user = new User();
        BeanUtils.copyProperties(userQuery, user);
        List<User> userList = userMapper.selectByAll(user);
        List<UserVO> userVOList = JSON.parseArray(JSON.toJSONString(userList), UserVO.class);
        logger.info("queryUser：查询用户信息成功，出参: userVOList = {}", userVOList);

        return new PageInfo<>(userVOList);
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        userDTO.setUpdateTime(DateUtil.getCurrentTimeString());
        logger.info("listUser：修改一条用户信息，入参: userDTO = {}", userDTO);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        int row = userMapper.updateByUserId(user);
        logger.info("listUser：修改一条用户信息，出参: row = {}", row);

        return row;
    }
}
