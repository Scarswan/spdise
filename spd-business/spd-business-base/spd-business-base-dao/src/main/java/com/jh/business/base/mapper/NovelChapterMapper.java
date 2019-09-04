package com.jh.business.base.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.base.NovelChapter;

public interface NovelChapterMapper extends BaseMapper<NovelChapter> {

    List<NovelChapter> selectByNovelId(@Param("novelId")String novelId);

    int updateByChapterId(@Param("updated")NovelChapter updated);


}