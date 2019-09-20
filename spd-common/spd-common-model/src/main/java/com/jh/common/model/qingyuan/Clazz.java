package com.jh.common.model.qingyuan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_class")
public class Clazz {
    /**
     * 班级主键id
     */
    @TableId(value = "class_id", type = IdType.INPUT)
    private String classId;

    /**
     * 班级名
     */
    @TableField(value = "class_name")
    private String className;

    /**
     * 班级课程
     */
    @TableField(value = "class_curriculum")
    private Integer classCurriculum;

    /**
     * 任课老师
     */
    @TableField(value = "teacher_id")
    private String teacherId;

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

    public static final String COL_CLASS_ID = "class_id";

    public static final String COL_CLASS_NAME = "class_name";

    public static final String COL_CLASS_CURRICULUM = "class_curriculum";

    public static final String COL_TEACHER_ID = "teacher_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}