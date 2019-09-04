package com.jh.business.base.service;

import com.jh.common.model.base.NovelChapter;

import java.util.List;

public interface NovelChapterService {

    /**
     * 更新章节
     *
     * @param novelChapter
     * @return
     */
    int saveChapters(NovelChapter novelChapter);

    /**
     * 获取章节目录
     *
     * @param novelId
     * @return
     */
    List<NovelChapter> getCatalog(String novelId);

    /**
     * 获取章节信息
     *
     * @param chapterId
     * @return
     */
    NovelChapter getChapterInfo(String chapterId);

}
