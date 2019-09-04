package com.jh.business.base.service;

import com.github.pagehelper.PageInfo;
import com.jh.common.model.base.Novel;
import com.jh.common.query.base.NovelQuery;

import java.util.List;

public interface NovelService {

    /**
     * 上传一本小说
     *
     * @param novel
     * @return
     */
    int upperShelfNovel(Novel novel);

    /**
     * 下架一本小说
     *
     * @param novelId
     * @return
     */
    int lowerShelfNovel(String novelId);

    /**
     * 批量审核
     *
     * @param novelIds
     * @return
     */
    int toExamine(List<String> novelIds);

    /**
     * 查询小说分页
     *
     * @param novelQuery
     * @return
     */
    PageInfo<Novel> queryNovel(NovelQuery novelQuery);
}
