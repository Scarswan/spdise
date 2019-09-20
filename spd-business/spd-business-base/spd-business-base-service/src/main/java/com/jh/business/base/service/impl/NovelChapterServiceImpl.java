package com.jh.business.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.business.base.mapper.NovelChapterMapper;
import com.jh.business.base.service.NovelChapterService;
import com.jh.common.dto.base.NovelChapterDTO;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.model.base.NovelChapter;
import com.jh.common.query.base.NovelChapterQuery;
import com.jh.common.util.StringUtil;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import com.jh.common.vo.base.NovelChapterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelChapterServiceImpl implements NovelChapterService {

    private Logger logger = LoggerFactory.getLogger(NovelChapterServiceImpl.class);

    @Autowired
    private NovelChapterMapper novelChapterMapper;

    @Override
    public int saveChapters(NovelChapterDTO novelChapterDTO) {
        novelChapterDTO.setChapterId(Sequence.generateBaseId());
        novelChapterDTO.setIsDelete(YesNoEnum.NO_CODE.getCode());
        novelChapterDTO.setCreateTime(DateUtil.getCurrentTimeString());
        logger.info("saveChapters: 更新章节, 入参: novelChapterDTO = {}", novelChapterDTO);
        NovelChapter novelChapter = new NovelChapter();
        BeanUtils.copyProperties(novelChapterDTO, novelChapter);
        int row = novelChapterMapper.insert(novelChapter);
        logger.info("saveChapters: 更新章节成功, 出参: row = {}", row);

        return row;
    }

    @Override
    public PageInfo<NovelChapterVO> getCatalog(NovelChapterQuery novelChapterQuery) {
        logger.info("getCatalog: 获取章节目录, 入参: novelChapterQuery = {}", novelChapterQuery);
        List<NovelChapter> novelChapterList = novelChapterMapper.selectByNovelId(novelChapterQuery.getNovelId());
        novelChapterList.forEach(
                novelChapter -> novelChapter.setChapterName(
                        StringUtil.toChinese(String.valueOf(novelChapter.getChapterIndex()))
                )
        );
        PageHelper.startPage(novelChapterQuery.getPageNum(), novelChapterQuery.getPageSize());
        List<NovelChapterVO> novelChapterVOList = JSON.parseArray(JSON.toJSONString(novelChapterList), NovelChapterVO.class);
        logger.info("getCatalog: 获取章节目录成功, 出参: novelChapterVOList = {}", novelChapterVOList);

        return new PageInfo<>(novelChapterVOList);
    }

    @Override
    public NovelChapterVO getChapterInfo(String chapterId) {
        logger.info("getChapterInfo: 获取章节信息, 入参: chapterId = {}", chapterId);
        QueryWrapper<NovelChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chapter_id", chapterId);
        queryWrapper.eq("is_delete", 2);
        NovelChapter novelChapter = novelChapterMapper.selectOne(queryWrapper);
        novelChapter.setChapterName(StringUtil.toChinese(String.valueOf(novelChapter.getChapterIndex())));
        NovelChapterVO novelChapterVO = new NovelChapterVO();
        BeanUtils.copyProperties(novelChapter, novelChapterVO);
        logger.info("getCatalog: 获取章节信息成功, 出参: novelChapter = {}", novelChapter);

        return novelChapterVO;
    }

    @Override
    public int updateChapterInfo(NovelChapterDTO novelChapterDTO) {
        novelChapterDTO.setUpdateTime(DateUtil.getCurrentTimeString());
        logger.info("updateChapterInfo: 修改章节内容, 入参: novelChapterDTO = {}", novelChapterDTO);
        NovelChapter novelChapter = new NovelChapter();
        BeanUtils.copyProperties(novelChapterDTO, novelChapter);
        int row = novelChapterMapper.updateByChapterId(novelChapter);
        logger.info("updateChapterInfo: 修改章节内容成功, 出参: row = {}", row);

        return row;
    }
}
