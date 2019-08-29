package com.jh.business.base.service;

import com.jh.common.model.base.User;

/**
 * @blame 杨赋
 */
public interface UserService {

    /**
     * 保存一条用户信息，若已存在，则返回0
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 查询一条用户信息
     * @param user
     * @return
     */
    User get(User user);

}
