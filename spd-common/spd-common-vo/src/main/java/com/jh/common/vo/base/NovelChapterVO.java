package com.jh.common.vo.base;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "spd_novel_chapter", autoResultMap = true)
public class NovelChapterVO {
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
}
