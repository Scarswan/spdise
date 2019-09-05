package com.jh.business.base.service;

import com.jh.business.base.mapper.NovelClicksMapper;
import com.jh.common.enums.TimeEnum;
import com.jh.common.model.base.NovelClicks;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jh.business.base.service.impl.NovelClicksService;

@Service
public class NovelClicksServiceImpl implements NovelClicksService {

    private Logger logger = LoggerFactory.getLogger(NovelClicksServiceImpl.class);

    @Autowired
    private NovelClicksMapper novelClicksMapper;

    @Override
    public int save(NovelClicks novelClicks) {
        novelClicks.setClId(Sequence.generateBaseId());
        novelClicks.setCreateTime(DateUtil.getCurrentTimeString());
        logger.info("save: 新增一条点击量记录，入参: novelClicks = {}", novelClicks);
        int row = novelClicksMapper.insert(novelClicks);
        logger.info("save: 新增一条点击量记录成功，出参: row = {}", row);

        return row;
    }

    @Override
    public int resetClicks(TimeEnum timeEnum) {
        NovelClicks novelClicks = new NovelClicks();
        switch (timeEnum.getCode()) {
            case 4:
                novelClicks.setClDay(0);
                break;
            case 5:
                novelClicks.setClWeek(0);
                break;
            case 6:
                novelClicks.setClMonth(0);
                break;
            case 7:
                novelClicks.setClQuarter(0);
                break;
            case 8:
                novelClicks.setClYear(0);
                break;
        }
        novelClicks.setUpdateTime(DateUtil.getCurrentTimeString());
        logger.info("resetClicks: 重置点击量，入参: timeEnum = {}", timeEnum);
        int rows = novelClicksMapper.update(novelClicks);
        logger.info("resetClicks: 重置点击量成功，出参: rows = {}", rows);

        return rows;
    }
}
