package com.jh.common.vo.base;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "spd_novel", autoResultMap = true)
public class NovelVO {
    /**
     * 小说主键id
     */
    private String novelId;

    /**
     * 小说名
     */
    private String novelName;

    /**
     * 作者
     */
    private String novelAuthor;

    /**
     * 小说简介
     */
    private String novelIntroduction;

    /**
     * 小说封面图片
     */
    private String novelCover;

    /**
     * 小说类型
     */
    private String novelType;

    /**
     * 收费标准
     */
    private Integer novelFeeStandard;

    /**
     * 收费具体
     */
    private Integer novelFeeSpecific;

    /**
     * 章节数
     */
    private Integer novelChapterNumber;

    /**
     * 是否完结
     */
    private Integer isEnd;

    /**
     * 完结时间
     */
    private String novelEndTime;
}
