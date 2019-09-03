package com.jh.common.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "spd_novel")
public class Novel {
    /**
     * 小说主键id
     */
    @TableId(value = "n_id", type = IdType.INPUT)
    private String nId;

    /**
     * 小说名
     */
    @TableField(value = "n_name")
    private String nName;

    /**
     * 作者
     */
    @TableField(value = "n_author")
    private String nAuthor;

    /**
     * 小说简介
     */
    @TableField(value = "n_introduction")
    private String nIntroduction;

    /**
     * 小说封面图片
     */
    @TableField(value = "n_cover")
    private String nCover;

    /**
     * 小说类型
     */
    @TableField(value = "n_type")
    private String nType;

    /**
     * 收费标准
     */
    @TableField(value = "n_fee_standard")
    private Integer nFeeStandard;

    /**
     * 小说状态
     */
    @TableField(value = "n_statu")
    private Integer nStatu;

    /**
     * 章节数
     */
    @TableField(value = "n_chapter_number")
    private Integer nChapterNumber;

    /**
     * 完结时间
     */
    @TableField(value = "n_end_time")
    private String nEndTime;

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

    public static final String COL_N_ID = "n_id";

    public static final String COL_N_NAME = "n_name";

    public static final String COL_N_AUTHOR = "n_author";

    public static final String COL_N_INTRODUCTION = "n_introduction";

    public static final String COL_N_COVER = "n_cover";

    public static final String COL_N_TYPE = "n_type";

    public static final String COL_N_FEE_STANDARD = "n_fee_standard";

    public static final String COL_N_STATU = "n_statu";

    public static final String COL_N_CHAPTER_NUMBER = "n_chapter_number";

    public static final String COL_N_END_TIME = "n_end_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}