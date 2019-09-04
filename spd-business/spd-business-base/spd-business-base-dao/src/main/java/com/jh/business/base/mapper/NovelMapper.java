package com.jh.business.base.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.Novel;

public interface NovelMapper extends BaseMapper<Novel> {

    int updateByNovelId(@Param("updated")Novel updated);

    List<Novel> selectByAll(@Param("novel") Novel novel);

}