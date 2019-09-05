package com.jh.business.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.business.base.mapper.NovelMapper;
import com.jh.business.base.service.NovelService;
import com.jh.common.dto.base.NovelDTO;
import com.jh.common.enums.NovelStatusEnum;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.model.base.Novel;
import com.jh.common.model.base.NovelClicks;
import com.jh.common.po.base.NovelPO;
import com.jh.common.query.base.NovelQuery;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import com.jh.common.vo.base.NovelVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelServiceImpl implements NovelService {

    private Logger logger = LoggerFactory.getLogger(NovelServiceImpl.class);

    @Autowired
    private NovelMapper novelMapper;

    @Autowired
    private NovelClicksService novelClicksService;

    @Override
    public int upperShelfNovel(NovelDTO novelDTO) {
        novelDTO.setNovelId(Sequence.generateBaseId());
        if (StringUtils.isBlank(novelDTO.getNovelIntroduction())) {
            novelDTO.setNovelIntroduction("作者偷懒了，没有上传简介哦~");
        }
        novelDTO.setNovelStatus(NovelStatusEnum.UPLOAD.getCode());
        novelDTO.setNovelChapterNumber(0);
        novelDTO.setIsEnd(YesNoEnum.NO_CODE.getCode());
        novelDTO.setCreateTime(DateUtil.getCurrentTimeString());
        Novel novel = new Novel();
        BeanUtils.copyProperties(novelDTO, novel);
        logger.info("upperShelfNovel: 发布一本小说，入参: novelDTO = {}", novelDTO);
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
    public int toExamineBatch(NovelPO novelPO) {
        logger.info("toExamineBatch: 批量审核，入参: novelDTO = {}", novelPO);
        int rows = 0;
        for (String novelId : novelPO.getNovelIds()) {
            Novel novel = new Novel();
            novel.setNovelId(novelId);
            novel.setUpdateTime(DateUtil.getCurrentTimeString());
            novel.setNovelStatus(NovelStatusEnum.AUDIT_UPPER_SHELF.getCode());
            rows += novelMapper.updateByNovelId(novel);

            NovelClicks novelClicks = new NovelClicks();
            novelClicks.setNovelId(novel.getNovelId());
            novelClicksService.save(novelClicks);
        }
        logger.info("toExamineBatch: 批量审核成功，出参: rows = {}", rows);

        return rows;
    }

    @Override
    public PageInfo<NovelVO> queryNovelPage(NovelQuery novelQuery) {
        logger.info("queryNovelPage: 查询小说分页，入参: novelQuery = {}", novelQuery);
        Novel novel = new Novel();
        novel.setNovelStatus(novelQuery.getNovelStatus());
        novel.setIsEnd(novelQuery.getIsEnd());
        novel.setNovelType(String.valueOf(novelQuery.getNovelType()));
        novel.setNovelStatus(NovelStatusEnum.AUDIT_UPPER_SHELF.getCode());
        List<Novel> novelList = novelMapper.selectByAll(novel);
        PageHelper.startPage(novelQuery.getPageNum(), novelQuery.getPageSize());
        List<NovelVO> novelVOList = JSON.parseArray(JSON.toJSONString(novelList), NovelVO.class);
        logger.info("queryNovelPage: 查询小说分页，出参: novelVOList = {}", novelVOList);

        return new PageInfo<>(novelVOList);
    }
}
