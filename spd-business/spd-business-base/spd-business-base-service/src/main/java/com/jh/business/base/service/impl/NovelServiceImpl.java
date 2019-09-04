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

import java.util.List;

@Service
public class NovelServiceImpl implements NovelService {

    private Logger logger = LoggerFactory.getLogger(NovelServiceImpl.class);

    @Autowired
    private NovelMapper novelMapper;

    @Override
    public int upperShelfNovel(Novel novel) {
        novel.setNovelId(Sequence.generateBaseId());
        if (StringUtils.isBlank(novel.getNovelIntroduction())) {
            novel.setNovelIntroduction("作者偷懒了，没有上传简介哦~");
        }
        novel.setNovelStatus(NovelStatusEnum.UPLOAD.getCode());
        novel.setNovelChapterNumber(0);
        novel.setCreateTime(DateUtil.getCurrentTimeString());
        logger.info("upperShelfNovel: 发布一本小说，入参: novel = {}", novel);
        int row = novelMapper.insert(novel);
        logger.info("upperShelfNovel: 发布一本小说成功，出参: row = {}", row);
        return row;
    }

    @Override
    public int lowerShelfNovel(String novelId) {
        Novel novel = new Novel();
        novel.setNovelId(novelId);
        novel.setUpdateTime(DateUtil.getCurrentTimeString());
        novel.setNovelStatus(NovelStatusEnum.LOWER_SHELF.getCode());
        logger.info("lowerShelfNovel: 下架一本小说，入参: novelId = {}", novelId);
        int row = novelMapper.updateByNovelId(novel);
        logger.info("upperShelfNovel: 下架一本小说成功，出参: row = {}", row);

        return row;
    }

    @Override
    public int toExamine(List<String> novelIds) {
        logger.info("lowerShelfNovel: 批量审核，入参: novelIds = {}", novelIds);
        int rows = 0;
        for (String novelId : novelIds) {
            Novel novel = new Novel();
            novel.setNovelId(novelId);
            novel.setUpdateTime(DateUtil.getCurrentTimeString());
            novel.setNovelStatus(NovelStatusEnum.UPPER_SHELF.getCode());
            rows += novelMapper.updateByNovelId(novel);
        }
        logger.info("upperShelfNovel: 批量审核成功，出参: rows = {}", rows);

        return rows;
    }
}
