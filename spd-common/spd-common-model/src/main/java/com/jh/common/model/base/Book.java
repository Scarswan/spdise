package com.jh.common.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "spd_book")
public class Book {
    /**
     * 书籍主键id
     */
    @TableId(value = "b_id", type = IdType.INPUT)
    private String bId;

    /**
     * 书名
     */
    @TableField(value = "b_name")
    private String bName;

    /**
     * 作者
     */
    @TableField(value = "b_author")
    private String bAuthor;

    /**
     * 书籍简介
     */
    @TableField(value = "b_introduction")
    private String bIntroduction;

    /**
     * 书籍封面图片
     */
    @TableField(value = "b_cover")
    private String bCover;

    /**
     * 书籍类型
     */
    @TableField(value = "b_type")
    private String bType;

    /**
     * 收费标准
     */
    @TableField(value = "b_fee_standard")
    private Integer bFeeStandard;

    /**
     * 书籍状态
     */
    @TableField(value = "b_statu")
    private Integer bStatu;

    /**
     * 章节数
     */
    @TableField(value = "b_chapter_number")
    private Integer bChapterNumber;

    /**
     * 完结时间
     */
    @TableField(value = "b_end_time")
    private String bEndTime;

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

    public static final String COL_B_ID = "b_id";

    public static final String COL_B_NAME = "b_name";

    public static final String COL_B_AUTHOR = "b_author";

    public static final String COL_B_INTRODUCTION = "b_introduction";

    public static final String COL_B_COVER = "b_cover";

    public static final String COL_B_TYPE = "b_type";

    public static final String COL_B_FEE_STANDARD = "b_fee_standard";

    public static final String COL_B_STATU = "b_statu";

    public static final String COL_B_CHAPTER_NUMBER = "b_chapter_number";

    public static final String COL_B_END_TIME = "b_end_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}