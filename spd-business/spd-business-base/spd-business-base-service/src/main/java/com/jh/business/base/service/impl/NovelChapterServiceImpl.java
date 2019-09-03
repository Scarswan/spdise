package com.jh.business.base.service.impl;

import com.jh.business.base.mapper.NovelChapterMapper;
import com.jh.business.base.service.NovelChapterService;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.model.base.NovelChapter;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NovelChapterServiceImpl implements NovelChapterService {

    private Logger logger = LoggerFactory.getLogger(NovelChapterServiceImpl.class);

    @Autowired
    private NovelChapterMapper novelChapterMapper;

    @Override
    public int saveChapters(NovelChapter novelChapter) {
        novelChapter.setChapterId(Sequence.generateBaseId());
        novelChapter.setIsDelete(YesNoEnum.NO_CODE.getCode());
        novelChapter.setCreateTime(DateUtil.getCurrentTimeString());
        logger.info("saveChapters: 更新章节, 入参: novelChapter = {}", novelChapter);
        int row = novelChapterMapper.insert(novelChapter);
        logger.info("saveChapters: 更新章节成功, 返参: row = {}", row);

        return row;
    }

    @Override
    public Map<String, String> getCatalog(String novelId) {
        Map<String, String> resultMap = new HashMap<>();
        logger.info("getCatalog: 获取章节目录, 入参: novelId = {}", novelId);
        List<NovelChapter> novelChapterList = novelChapterMapper.selectByNovelId(novelId);
        novelChapterList.forEach(novelChapter -> resultMap.put(novelChapter.getChapterId(), novelChapter.getChapterName()));
        logger.info("getCatalog: 获取章节目录成功, 出参: resultMap = {}", resultMap);

        return resultMap;
    }
}
