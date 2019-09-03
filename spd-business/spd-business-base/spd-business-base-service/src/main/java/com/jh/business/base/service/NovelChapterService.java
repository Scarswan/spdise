package com.jh.business.base.service;

import com.jh.common.model.base.NovelChapter;

public interface NovelChapterService {

    /**
     * 更新章节
     *
     * @param novelChapter
     * @return
     */
    int saveChapters(NovelChapter novelChapter);

}
