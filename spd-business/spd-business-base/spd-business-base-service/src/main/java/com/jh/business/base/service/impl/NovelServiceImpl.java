package com.jh.business.base.service.impl;

import com.jh.business.base.mapper.NovelMapper;
import com.jh.business.base.service.NovelService;
import com.jh.common.enums.NovelStatusEnum;
import com.jh.common.model.base.Novel;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NovelServiceImpl implements NovelService {

    private Logger logger = LoggerFactory.getLogger(NovelServiceImpl.class);

    @Autowired
    private NovelMapper novelMapper;

    @Override
    public int releaseNovel(Novel novel) {
        novel.setNovelId(Sequence.generateBaseId());
        if (StringUtils.isBlank(novel.getNovelIntroduction())) {
            novel.setNovelIntroduction("作者偷懒了，没有上传简介哦~");
        }
        novel.setNovelStatus(NovelStatusEnum.UPPER_SHELF.getCode());
        novel.setNovelChapterNumber(0);
        novel.setCreateTime(DateUtil.getCurrentTimeString());
        logger.info("releaseNovel: 发布一本小说，入参: novel = {}", novel);
        int row = novelMapper.insert(novel);
        logger.info("releaseNovel: 发布一本小说成功，返参: row = {}", row);
        return row;
    }
}
