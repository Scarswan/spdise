package com.jh.business.base.service;

import com.github.pagehelper.PageInfo;
import com.jh.common.dto.base.NovelChapterDTO;
import com.jh.common.model.base.NovelChapter;
import com.jh.common.query.base.NovelChapterQuery;
import com.jh.common.vo.base.NovelChapterVO;

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
     * @param novelChapterQuery
     * @return
     */
    PageInfo<NovelChapterVO> getCatalog(NovelChapterQuery novelChapterQuery);

    /**
     * 获取章节信息
     *
     * @param chapterId
     * @return
     */
    NovelChapterVO getChapterInfo(String chapterId);

    /**
     * 修改章节内容
     *
     * @param novelChapterDTO
     * @return
     */
    int updateChapterInfo(NovelChapterDTO novelChapterDTO);

}
