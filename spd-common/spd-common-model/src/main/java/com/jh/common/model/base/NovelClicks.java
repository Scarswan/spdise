package com.jh.common.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "spd_novel_clicks")
public class NovelClicks {
    /**
     * 小说点击量主键id
     */
    @TableId(value = "cl_id", type = IdType.INPUT)
    private String clId;

    /**
     * 小说主键id
     */
    @TableField(value = "novel_id")
    private String novelId;

    /**
     * 当日点击量
     */
    @TableField(value = "cl_day")
    private Integer clDay;

    /**
     * 当周点击量
     */
    @TableField(value = "cl_week")
    private Integer clWeek;

    /**
     * 当月点击量
     */
    @TableField(value = "cl_month")
    private Integer clMonth;

    /**
     * 当季点击量
     */
    @TableField(value = "cl_quarter")
    private Integer clQuarter;

    /**
     * 当年点击量
     */
    @TableField(value = "cl_year")
    private Integer clYear;

    /**
     * 总点击量
     */
    @TableField(value = "cl_total")
    private Integer clTotal;

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

    public static final String COL_CL_ID = "cl_id";

    public static final String COL_NOVEL_ID = "novel_id";

    public static final String COL_CL_DAY = "cl_day";

    public static final String COL_CL_WEEK = "cl_week";

    public static final String COL_CL_MONTH = "cl_month";

    public static final String COL_CL_QUARTER = "cl_quarter";

    public static final String COL_CL_YEAR = "cl_year";

    public static final String COL_CL_TOTAL = "cl_total";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}