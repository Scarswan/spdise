package com.jh.common.query.qingyuan;

import lombok.Data;

@Data
public class StudentQuery {
    /**
     * 学员主键id
     */
    private String studentId;

    /**
     * 姓名
     */
    private String studentName;

    /**
     * 登录密码
     */
    private String studentPassword;

    /**
     * 年龄
     */
    private Integer studentAge;

    /**
     * 学员本人联系电话
     */
    private String studentPhone;

    /**
     * 监护人姓名
     */
    private String studentGuardianName;

    /**
     * 监护人联系电话
     */
    private String studentGuardianPhone;

    /**
     * 监护人与学员关系
     */
    private Integer studentGuardianRelationship;

    /**
     * 所选课程
     */
    private Integer studentCurriculum;

    /**
     * 所在班级主键id
     */
    private String classId;

    /**
     * 首次入学时间
     */
    private String studentFirstEntrance;

    /**
     * 已学课程
     */
    private String studentAlreadyCurriculum;

    /**
     * 围棋段位
     */
    private Integer studentRank;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 数量
     */
    private Integer pageSize = 10;
}
