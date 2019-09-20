package com.jh.common.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "spd_user", autoResultMap = true)
public class User {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "user_password")
    private String userPassword;

    /**
     * 用户头像
     */
    @TableField(value = "user_head_portrait")
    private String userHeadPortrait;

    /**
     * 真实姓名
     */
    @TableField(value = "user_real_name")
    private String userRealName;

    /**
     * 用户性别
     */
    @TableField(value = "user_gender")
    private Integer userGender;

    /**
     * 用户年龄
     */
    @TableField(value = "user_age")
    private Integer userAge;

    /**
     * 手机号码
     */
    @TableField(value = "user_phone")
    private String userPhone;

    /**
     * 身份证
     */
    @TableField(value = "id_card")
    private String idCard;

    /**
     * 邮箱
     */
    @TableField(value = "user_email")
    private String userEmail;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private String createTime;

    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private String updateTime;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_USER_PASSWORD = "user_password";

    public static final String COL_USER_HEAD_PORTRAIT = "user_head_portrait";

    public static final String COL_USER_REAL_NAME = "user_real_name";

    public static final String COL_USER_GENDER = "user_gender";

    public static final String COL_USER_AGE = "user_age";

    public static final String COL_USER_PHONE = "user_phone";

    public static final String COL_ID_CARD = "id_card";

    public static final String COL_USER_EMAIL = "user_email";

    public static final String COL_IS_DELETE = "is_delete";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}