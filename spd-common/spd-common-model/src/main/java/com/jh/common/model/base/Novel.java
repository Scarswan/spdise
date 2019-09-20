package com.jh.common.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_novel")
public class Novel {
    /**
     * 小说主键id
     */
    @TableId(value = "novel_id", type = IdType.INPUT)
    private String novelId;

    /**
     * 小说名
     */
    @TableField(value = "novel_name")
    private String novelName;

    /**
     * 作者
     */
    @TableField(value = "novel_author")
    private String novelAuthor;

    /**
     * 小说简介
     */
    @TableField(value = "novel_introduction")
    private String novelIntroduction;

    /**
     * 小说封面图片
     */
    @TableField(value = "novel_cover")
    private String novelCover;

    /**
     * 小说类型
     */
    @TableField(value = "novel_type")
    private String novelType;

    /**
     * 收费标准
     */
    @TableField(value = "novel_fee_standard")
    private Integer novelFeeStandard;

    /**
     * 收费具体
     */
    @TableField(value = "novel_fee_specific")
    private Integer novelFeeSpecific;

    /**
     * 小说状态
     */
    @TableField(value = "novel_status")
    private Integer novelStatus;

    /**
     * 章节数
     */
    @TableField(value = "novel_chapter_number")
    private Integer novelChapterNumber;

    /**
     * 是否完结
     */
    @TableField(value = "is_end")
    private Integer isEnd;

    /**
     * 完结时间
     */
    @TableField(value = "novel_end_time")
    private String novelEndTime;

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

    public static final String COL_NOVEL_ID = "novel_id";

    public static final String COL_NOVEL_NAME = "novel_name";

    public static final String COL_NOVEL_AUTHOR = "novel_author";

    public static final String COL_NOVEL_INTRODUCTION = "novel_introduction";

    public static final String COL_NOVEL_COVER = "novel_cover";

    public static final String COL_NOVEL_TYPE = "novel_type";

    public static final String COL_NOVEL_FEE_STANDARD = "novel_fee_standard";

    public static final String COL_NOVEL_FEE_SPECIFIC = "novel_fee_specific";

    public static final String COL_NOVEL_STATUS = "novel_status";

    public static final String COL_NOVEL_CHAPTER_NUMBER = "novel_chapter_number";

    public static final String COL_IS_END = "is_end";

    public static final String COL_NOVEL_END_TIME = "novel_end_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}