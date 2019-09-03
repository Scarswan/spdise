package com.jh.business.base.controller;

import com.jh.business.base.service.NovelChapterService;
import com.jh.common.model.base.NovelChapter;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
     * @return Map<String, String> 第一个参数为章节 id，第二个参数为章节名
     */
    @PostMapping("/getCatalog")
    public ResponseMsg<Map<String, String>> getCatalog(@RequestParam("novelId") String novelId) {
        Map<String, String> resultMap = novelChapterService.getCatalog(novelId);

        return ResponseMsg.success(resultMap);
    }

}
