package com.jh.business.demo.mapper.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jh.model.demo.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PlusUserMapper implements BaseMapper<User> {
    @Override
    public int insert(User entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<User> wrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return 0;
    }

    @Override
    public int updateById(User entity) {
        return 0;
    }

    @Override
    public int update(User entity, Wrapper<User> updateWrapper) {
        return 0;
    }

    @Override
    public User selectById(Serializable id) {
        return null;
    }

    @Override
    public List<User> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<User> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public User selectOne(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public Integer selectCount(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<User> selectList(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public IPage<User> selectPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return null;
    }
}
