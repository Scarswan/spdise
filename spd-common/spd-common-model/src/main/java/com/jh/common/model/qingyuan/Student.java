package com.jh.common.model.qingyuan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_student")
public class Student {
    /**
     * 学员主键id
     */
    @TableId(value = "student_id", type = IdType.INPUT)
    private String studentId;

    /**
     * 姓名
     */
    @TableField(value = "student_name")
    private String studentName;

    /**
     * 登录密码
     */
    @TableField(value = "student_password")
    private String studentPassword;

    /**
     * 年龄
     */
    @TableField(value = "student_age")
    private Integer studentAge;

    /**
     * 学员本人联系电话
     */
    @TableField(value = "student_phone")
    private String studentPhone;

    /**
     * 监护人姓名
     */
    @TableField(value = "student_guardian_name")
    private String studentGuardianName;

    /**
     * 监护人联系电话
     */
    @TableField(value = "student_guardian_phone")
    private String studentGuardianPhone;

    /**
     * 监护人与学员关系
     */
    @TableField(value = "student_guardian_relationship")
    private Integer studentGuardianRelationship;

    /**
     * 所选课程
     */
    @TableField(value = "student_curriculum")
    private Integer studentCurriculum;

    /**
     * 所在班级主键id
     */
    @TableField(value = "class_id")
    private String classId;

    /**
     * 首次入学时间
     */
    @TableField(value = "student_first_entrance")
    private String studentFirstEntrance;

    /**
     * 已学课程
     */
    @TableField(value = "student_already_curriculum")
    private String studentAlreadyCurriculum;

    /**
     * 围棋段位
     */
    @TableField(value = "student_rank")
    private Integer studentRank;

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

    public static final String COL_STUDENT_ID = "student_id";

    public static final String COL_STUDENT_NAME = "student_name";

    public static final String COL_STUDENT_PASSWORD = "student_password";

    public static final String COL_STUDENT_AGE = "student_age";

    public static final String COL_STUDENT_PHONE = "student_phone";

    public static final String COL_STUDENT_GUARDIAN_NAME = "student_guardian_name";

    public static final String COL_STUDENT_GUARDIAN_PHONE = "student_guardian_phone";

    public static final String COL_STUDENT_GUARDIAN_RELATIONSHIP = "student_guardian_relationship";

    public static final String COL_STUDENT_CURRICULUM = "student_curriculum";

    public static final String COL_CLASS_ID = "class_id";

    public static final String COL_STUDENT_FIRST_ENTRANCE = "student_first_entrance";

    public static final String COL_STUDENT_ALREADY_CURRICULUM = "student_already_curriculum";

    public static final String COL_STUDENT_RANK = "student_rank";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}