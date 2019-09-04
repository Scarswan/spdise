package com.jh.business.base.service;

import com.github.pagehelper.PageInfo;
import com.jh.common.dto.base.NovelDTO;
import com.jh.common.model.base.Novel;
import com.jh.common.po.base.NovelPO;
import com.jh.common.query.base.NovelQuery;
import com.jh.common.vo.base.NovelVO;

public interface NovelService {

    /**
     * 上传一本小说
     *
     * @param novelDTO
     * @return
     */
    int upperShelfNovel(NovelDTO novelDTO);

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
     * @param novelPO
     * @return
     */
    int toExamine(NovelPO novelPO);

    /**
     * 查询小说分页
     *
     * @param novelQuery
     * @return
     */
    PageInfo<NovelVO> queryNovel(NovelQuery novelQuery);
}
