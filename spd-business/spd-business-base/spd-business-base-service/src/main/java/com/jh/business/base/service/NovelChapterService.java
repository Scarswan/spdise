package com.jh.business.base.service;

import com.jh.common.dto.base.NovelChapterDTO;
import com.jh.common.model.base.NovelChapter;

import java.util.List;

public interface NovelChapterService {

    /**
     * 更新章节
     *
     * @param novelChapterDTO
     * @return
     */
    int saveChapters(NovelChapterDTO novelChapterDTO);

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

    /**
     * 修改章节内容
     *
     * @param novelChapterDTO
     * @return
     */
    int updateChapterInfo(NovelChapterDTO novelChapterDTO);

}
