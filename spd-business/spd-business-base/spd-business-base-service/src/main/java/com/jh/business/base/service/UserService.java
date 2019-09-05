package com.jh.business.base.service;

import com.github.pagehelper.PageInfo;
import com.jh.common.dto.base.UserDTO;
import com.jh.common.model.base.User;
import com.jh.common.query.base.UserQuery;
import com.jh.common.vo.base.UserVO;

import java.util.List;

public interface UserService {

    /**
     * 保存一条用户信息
     *
     * @param userDTO
     * @return
     */
    int save(UserDTO userDTO);

    /**
     * 批量新增用户信息
     * @param userDTOList
     * @return
     */
    int batchSave(List<UserDTO> userDTOList);

    /**
     * 查询用户信息
     *
     * @param userQuery
     * @return
     */
    PageInfo<UserVO> queryUser(UserQuery userQuery);

    /**
     * 修改一条用户信息
     *
     * @param userDTO
     * @return
     */
    int updateUser(UserDTO userDTO);

}
