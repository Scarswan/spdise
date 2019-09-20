package com.jh.business.base.controller;

import com.github.pagehelper.PageInfo;
import com.jh.business.base.service.NovelChapterService;
import com.jh.common.dto.base.NovelChapterDTO;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.query.base.NovelChapterQuery;
import com.jh.common.vo.base.NovelChapterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/novel/chapter")
public class NovelChapterController {

    @Autowired
    private NovelChapterService novelChapterService;

    /**
     * 更新章节
     *
     * @param novelChapterDTO
     * @return
     */
    @PostMapping("/saveChapters")
    public ResponseMsg saveChapters(@RequestBody NovelChapterDTO novelChapterDTO) {
        int row = novelChapterService.saveChapters(novelChapterDTO);

        return ResponseMsg.successRow(row);
    }

    /**
     * 获取章节目录
     *
     * @param novelChapterQuery
     * @return
     */
    @PostMapping("/getCatalog")
    public ResponseMsg<PageInfo<NovelChapterVO>> getCatalog(@RequestBody NovelChapterQuery novelChapterQuery) {
        PageInfo<NovelChapterVO> novelChapterVOPageInfo = novelChapterService.getCatalog(novelChapterQuery);

        return ResponseMsg.success(novelChapterVOPageInfo);
    }

    /**
     * 获取章节信息
     *
     * @param chapterId
     * @return
     */
    @PostMapping("/getChapterInfo")
    public ResponseMsg<NovelChapterVO> getChapterInfo(@RequestParam("chapterId") String chapterId) {
        NovelChapterVO novelChapterVO = novelChapterService.getChapterInfo(chapterId);

        return ResponseMsg.success(novelChapterVO);
    }

    /**
     * 修改章节内容
     *
     * @param novelChapterDTO
     * @return
     */
    @PostMapping("/update/chapterInfo")
    public ResponseMsg updateChapter(@RequestBody NovelChapterDTO novelChapterDTO) {
        int row = novelChapterService.updateChapterInfo(novelChapterDTO);

        return ResponseMsg.successRow(row);
    }

}
