package com.jh.common.query.qingyuan;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeacherQuery {
    /**
     * 教师主键id
     */
    private String teacherId;

    /**
     * 姓名
     */
    private String teacherName;

    /**
     * 联系电话
     */
    private String teacherPhone;

    /**
     * 性别
     */
    private Integer teacherGender;

    /**
     * 年龄
     */
    private Integer teacherAge;

    /**
     * 工资
     */
    private BigDecimal teacherWages;

    /**
     * 工资类型
     */
    private Integer wagesType;

    /**
     * 教学时长
     */
    private String teacherDuration;

    /**
     * 围棋段位
     */
    private Integer teacherRank;

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
