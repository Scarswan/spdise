package com.jh.business.base.service;

import com.jh.common.model.base.Novel;

public interface NovelService {

    /**
     * 发布一本小说
     *
     * @param novel
     * @return
     */
    int releaseNovel(Novel novel);

}
