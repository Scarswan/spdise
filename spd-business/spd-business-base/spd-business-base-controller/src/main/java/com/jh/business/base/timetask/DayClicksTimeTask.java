package com.jh.business.base.timetask;

import com.jh.business.base.service.impl.NovelClicksService;
import com.jh.common.enums.TimeEnum;
import com.jh.common.timetask.ITimeTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 每天0点执行一次，重置当天点击量
 */
@Component
@EnableScheduling
public class DayClicksTimeTask implements ITimeTask {

    private static Logger logger = LoggerFactory.getLogger(DayClicksTimeTask.class);

    @Autowired
    private NovelClicksService novelClicksService;

    @Scheduled(cron = "0/30 * * * * ? ")//"0 0 0 * * ? *")
    @Override
    public void Execution() {
        String desc = "重置当天点击量";
        logger.info("*********   定时任务: " + desc + " 执行   **************");
        novelClicksService.resetClicks(TimeEnum.DAY);
        logger.info("*********   定时任务: " + desc + " 完成   **************");
    }

}
