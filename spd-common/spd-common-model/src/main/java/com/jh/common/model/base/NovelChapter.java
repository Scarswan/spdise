package com.jh.common.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "spd_novel_chapter")
public class NovelChapter {
    /**
     * 章节主键id
     */
    @TableId(value = "c_id", type = IdType.INPUT)
    private String cId;

    /**
     * 小说主键id
     */
    @TableField(value = "n_id")
    private String nId;

    /**
     * 章节内容
     */
    @TableField(value = "c_content")
    private String cContent;

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

    public static final String COL_C_ID = "c_id";

    public static final String COL_N_ID = "n_id";

    public static final String COL_C_CONTENT = "c_content";

    public static final String COL_IS_DELETE = "is_delete";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}