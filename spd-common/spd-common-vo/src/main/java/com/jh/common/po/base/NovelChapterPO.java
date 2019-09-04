package com.jh.common.po.base;

import lombok.Data;

@Data
public class NovelChapterPO {
    /**
     * 章节主键id
     */
    private String chapterId;

    /**
     * 小说主键id
     */
    private String novelId;

    /**
     * 章节下标
     */
    private Integer chapterIndex;

    /**
     * 章节名
     */
    private String chapterName;

    /**
     * 章节内容
     */
    private String chapterContent;

    /**
     * 是否收费
     */
    private String isFee;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后修改时间
     */
    private String updateTime;
}
