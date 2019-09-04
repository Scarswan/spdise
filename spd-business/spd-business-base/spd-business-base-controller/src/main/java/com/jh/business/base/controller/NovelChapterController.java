package com.jh.business.base.controller;

import com.jh.business.base.service.NovelChapterService;
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
     * @param novelChapter NovelChapter 对象
     * @return 受影响的行数
     */
    @PostMapping("/saveChapters")
    public ResponseMsg saveChapters(@RequestBody NovelChapter novelChapter) {
        int row = novelChapterService.saveChapters(novelChapter);

        return ResponseMsg.success("row: " + row);
    }

    /**
     * 获取章节目录
     *
     * @param novelId 小说 id
     * @return 章节目录
     */
    @PostMapping("/get/catalog")
    public ResponseMsg<List<NovelChapter>> getCatalog(@RequestParam("novelId") String novelId) {
        List<NovelChapter> novelChapterList = novelChapterService.getCatalog(novelId);

        return ResponseMsg.success(novelChapterList);
    }

    /**
     * 获取章节信息
     *
     * @param chapterId 章节 id
     * @return 章节信息
     */
    @PostMapping("/get/chapter")
    public ResponseMsg<NovelChapter> getChapterInfo(@RequestParam("chapterId") String chapterId) {
        NovelChapter novelChapter = novelChapterService.getChapterInfo(chapterId);

        return ResponseMsg.success(novelChapter);
    }

}
