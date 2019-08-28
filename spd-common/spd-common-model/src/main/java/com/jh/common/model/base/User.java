package com.jh.common.model.base;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jh.model.Base;
import lombok.Data;

/**
 * @author YangFu
 * @data 2019/08/23 17:37
 */
@Data
@TableName(value = "spd_user",autoResultMap = true)
public class User extends Base {

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
     * 头像
     */
    private String userHeadPortrait;

    /**
     * 真实姓名
     */
    private String userRealName;

    /**
     * 性别
     */
    private int userGender;

    /**
     * 年龄
     */
    private int userAge;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 是否删除
     */
    private int isDelete;

}
