package com.jh.business.base.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.Novel;

public interface NovelMapper extends BaseMapper<Novel> {

    int updateByNovelId(@Param("updated")Novel updated);

}