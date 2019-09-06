package com.jh.business.base.timetask;

import com.jh.business.base.service.impl.NovelClicksService;
import com.jh.common.enums.TimeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 重置点击量
 */
@Component
@EnableScheduling
public class ClicksTimeTask {

    private static Logger logger = LoggerFactory.getLogger(ClicksTimeTask.class);

    @Autowired
    private NovelClicksService novelClicksService;

    /**
     * 每天0点，重置当天点击量
     */
    // 0 0 0 * * ?  测试用每一分钟执行一次
    @Scheduled(cron = "0 * * * * ? ")
    public void dayExecution() {
        String desc = "重置当天点击量";
        logger.info("*********   定时任务: " + desc + " 执行   **************");
        novelClicksService.resetClicks(TimeEnum.DAY);
        logger.info("*********   定时任务: " + desc + " 完成   **************");
    }

    /**
     * 每周一0点，重置当周点击量
     */
    @Scheduled(cron = "0 0 0 ? * 2 ")
    public void weekExecution() {
        String desc = "重置当周点击量";
        logger.info("*********   定时任务: " + desc + " 执行   **************");
        novelClicksService.resetClicks(TimeEnum.WEEK);
        logger.info("*********   定时任务: " + desc + " 完成   **************");
    }

    /**
     * 每月1号0点，重置当月点击量
     */
    @Scheduled(cron = "0 0 0 1 * ? ")
    public void monthExecution() {
        String desc = "重置当月点击量";
        logger.info("*********   定时任务: " + desc + " 执行   **************");
        novelClicksService.resetClicks(TimeEnum.MONTH);
        logger.info("*********   定时任务: " + desc + " 完成   **************");
    }

    /**
     * 每周季度第一天0点，重置当季度点击量
     * --01-01
     * --04-01
     * --07-01
     * --10-01
     */
    @Scheduled(cron = "0 0 0 1 1/3 ? ")
    public void quarterExecution() {
        String desc = "重置当季度点击量";
        logger.info("*********   定时任务: " + desc + " 执行   **************");
        novelClicksService.resetClicks(TimeEnum.QUARTER);
        logger.info("*********   定时任务: " + desc + " 完成   **************");
    }

    /**
     * 每年1月1号0点，重置当年点击量
     */
    @Scheduled(cron = "59 59 23 31 12 ? ")
    public void yearExecution() {
        String desc = "重置当年点击量";
        logger.info("*********   定时任务: " + desc + " 执行   **************");
        novelClicksService.resetClicks(TimeEnum.YEAR);
        logger.info("*********   定时任务: " + desc + " 完成   **************");
    }
}
