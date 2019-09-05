package com.jh.common.dto.base;

import lombok.Data;

@Data
public class UserDTO {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 用户头像
     */
    private String userHeadPortrait;

    /**
     * 真实姓名
     */
    private String userRealName;

    /**
     * 用户性别
     */
    private Integer userGender;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 手机号码
     */
    private String userPhone;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后修改时间
     */
    private String updateTime;
}
