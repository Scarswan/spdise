package com.jh.business.base.service;

import com.jh.common.model.base.NovelChapter;

import java.util.List;

public interface NovelChapterService {

    /**
     * 更新章节
     *
     * @param novelChapter NovelChapter 对象
     * @return 受影响的行数
     */
    int saveChapters(NovelChapter novelChapter);

    /**
     * 获取章节目录
     *
     * @param novelId 小说 id
     * @return 章节目录
     */
    List<NovelChapter> getCatalog(String novelId);

    /**
     * 获取章节信息
     *
     * @param chapterId 章节 id
     * @return 章节信息
     */
    NovelChapter getChapterInfo(String chapterId);

    /**
     * 修改章节内容
     *
     * @param novelChapter NovelChapter 对象
     * @return 受影响的行数
     */
    int updateChapterInfo(NovelChapter novelChapter);

}
