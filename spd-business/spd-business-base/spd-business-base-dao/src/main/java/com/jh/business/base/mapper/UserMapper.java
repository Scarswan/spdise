package com.jh.business.base.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.User;

/**
 * @blame 杨赋
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 批量增加用户信息
     * @param list
     * @return
     */
    int insertList(@Param("list") List<User> list);

    /**
     * 根据 userId 修改用户信息
     * @param updated
     * @param userId
     * @return
     */
    int updateByUserId(@Param("updated")User updated,@Param("userId")String userId);

}
