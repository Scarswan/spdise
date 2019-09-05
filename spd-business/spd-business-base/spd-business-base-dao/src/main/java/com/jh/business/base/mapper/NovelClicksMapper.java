package com.jh.business.base.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.NovelClicks;

public interface NovelClicksMapper extends BaseMapper<NovelClicks> {

    int update(@Param("updated")NovelClicks updated);
}