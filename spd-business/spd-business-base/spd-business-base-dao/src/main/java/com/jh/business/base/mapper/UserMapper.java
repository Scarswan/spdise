package com.jh.business.base.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.User;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 批量增加用户信息
     *
     * @param list
     * @return
     */
    int insertList(@Param("list") List<User> list);

    /**
     * 根据 userId 修改用户信息
     *
     * @param updated
     * @return
     */
    int updateByUserId(@Param("updated") User updated);

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    List<User> selectByAll(User user);

}
