package com.jh.common.query.base;

import lombok.Data;

@Data
public class UserQuery {
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
     * 页码
     */
    private Integer pageNum;

    /**
     * 数量
     */
    private Integer pageSize;
}
