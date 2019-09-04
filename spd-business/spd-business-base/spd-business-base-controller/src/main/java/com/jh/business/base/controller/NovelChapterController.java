package com.jh.business.base.controller;

import com.jh.business.base.service.NovelChapterService;
import com.jh.common.dto.base.NovelChapterDTO;
import com.jh.common.model.base.NovelChapter;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return ResponseMsg.success("row: " + row);
    }

    /**
     * 获取章节目录
     *
     * @param novelId
     * @return
     */
    @PostMapping("/getCatalog")
    public ResponseMsg<List<NovelChapter>> getCatalog(@RequestParam("novelId") String novelId) {
        List<NovelChapter> novelChapterList = novelChapterService.getCatalog(novelId);

        return ResponseMsg.success(novelChapterList);
    }

    /**
     * 获取章节信息
     *
     * @param chapterId
     * @return
     */
    @PostMapping("/getChapterInfo")
    public ResponseMsg<NovelChapter> getChapterInfo(@RequestParam("chapterId") String chapterId) {
        NovelChapter novelChapter = novelChapterService.getChapterInfo(chapterId);

        return ResponseMsg.success(novelChapter);
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

        return ResponseMsg.success("row: " + row);
    }

}
