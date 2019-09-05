package com.jh.business.base.service.impl;

import com.jh.common.enums.TimeEnum;
import com.jh.common.model.base.NovelClicks;

public interface NovelClicksService {

    /**
     * 新增一条点击量记录
     *
     * @param novelClicks
     * @return
     */
    int save(NovelClicks novelClicks);

    /**
     * 重置点击量
     *
     * @return
     */
    int resetClicks(TimeEnum timeEnum);

}
