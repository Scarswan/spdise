package com.jh.common.model.qingyuan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

import lombok.Data;

@Data
@TableName(value = "t_teacher")
public class Teacher {
    /**
     * 教师主键id
     */
    @TableId(value = "teacher_id", type = IdType.INPUT)
    private String teacherId;

    /**
     * 姓名
     */
    @TableField(value = "teacher_name")
    private String teacherName;

    /**
     * 登录密码
     */
    @TableField(value = "teacher_password")
    private String teacherPassword;

    /**
     * 联系电话
     */
    @TableField(value = "teacher_phone")
    private String teacherPhone;

    /**
     * 性别
     */
    @TableField(value = "teacher_gender")
    private Integer teacherGender;

    /**
     * 年龄
     */
    @TableField(value = "teacher_age")
    private Integer teacherAge;

    /**
     * 工资
     */
    @TableField(value = "teacher_wages")
    private BigDecimal teacherWages;

    /**
     * 工资类型
     * 1 按课时
     * 2 按天
     */
    @TableField(value = "wages_type")
    private Integer wagesType;

    /**
     * 教学时长
     */
    @TableField(value = "teacher_duration")
    private String teacherDuration;

    /**
     * 围棋段位
     */
    @TableField(value = "teacher_rank")
    private Integer teacherRank;

    /**
     * 是否删除
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

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

    public static final String COL_TEACHER_ID = "teacher_id";

    public static final String COL_TEACHER_NAME = "teacher_name";

    public static final String COL_TEACHER_PASSWORD = "teacher_password";

    public static final String COL_TEACHER_PHONE = "teacher_phone";

    public static final String COL_TEACHER_GENDER = "teacher_gender";

    public static final String COL_TEACHER_AGE = "teacher_age";

    public static final String COL_TEACHER_WAGES = "teacher_wages";

    public static final String COL_WAGES_TYPE = "wages_type";

    public static final String COL_TEACHER_DURATION = "teacher_duration";

    public static final String COL_TEACHER_RANK = "teacher_rank";

    public static final String COL_DEL_FLAG = "del_flag";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}