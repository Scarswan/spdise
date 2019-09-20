package com.jh.business.base.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.NovelClicks;

public interface NovelClicksMapper extends BaseMapper<NovelClicks> {

    /**
     * 修改所有的小说点击量
     *
     * @param updated
     * @return
     */
    int update(@Param("updated") NovelClicks updated);
}