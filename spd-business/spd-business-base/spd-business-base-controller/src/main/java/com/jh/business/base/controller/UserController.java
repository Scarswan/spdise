package com.jh.business.base.controller;

import com.github.pagehelper.PageInfo;
import com.jh.business.base.service.UserService;
import com.jh.common.dto.base.UserDTO;
import com.jh.common.enums.RetCode;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.query.base.UserQuery;
import com.jh.common.vo.base.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录或注册(根据手机号)
     *
     * @param userDTO
     * @return 行数
     */
    @PostMapping("/login/register")
    public ResponseMsg loginOrRegister(@RequestBody UserDTO userDTO) {
        int row = userService.save(userDTO);

        return ResponseMsg.successRow(row);
    }

    /**
     * 批量增添用户
     *
     * @param userDTOListList
     * @return
     */
    @PostMapping("/batch/save")
    public ResponseMsg batchSave(@RequestBody List<UserDTO> userDTOListList) {
        int rows = userService.batchSave(userDTOListList);

        return ResponseMsg.successRow(rows);
    }

    /**
     * 获取用户信息
     *
     * @param userQuery
     * @return
     */
    @GetMapping("/queryUser")
    public ResponseMsg<PageInfo<UserVO>> queryUser(@RequestBody UserQuery userQuery) {
        PageInfo<UserVO> userVOPageInfo = userService.queryUser(userQuery);

        return ResponseMsg.success(userVOPageInfo);
    }

    /**
     * 更新一条用户信息
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/update/userInfo")
    public ResponseMsg updateUser(@RequestBody UserDTO userDTO) {
        if (StringUtils.isNotBlank(userDTO.getUserId())) {
            return ResponseMsg.error(RetCode.PARAM_ERROR);
        }
        int row = userService.updateUser(userDTO);

        return ResponseMsg.successRow(row);
    }

}

