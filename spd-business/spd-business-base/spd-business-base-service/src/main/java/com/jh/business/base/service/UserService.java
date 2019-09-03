package com.jh.business.base.service;

import com.jh.common.model.base.User;

import java.util.List;

/**
 * @blame 杨赋
 */
public interface UserService {

    /**
     * 保存一条用户信息
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 批量新增用户信息
     * @param userList
     * @return
     */
    int batchSave(List<User> userList);

    /**
     * 查询一条用户信息
     *
     * @param user
     * @return
     */
    User getUserInfo(User user);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> listUser();

    /**
     * 修改一条用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

}
