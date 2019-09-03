package com.jh.business.base.service;

import com.jh.common.model.base.NovelChapter;

import java.util.Map;

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
    Map<String, String> getCatalog(String novelId);

}
