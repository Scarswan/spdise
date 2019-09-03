package com.jh.business.base.controller;

import com.jh.business.base.service.NovelChapterService;
import com.jh.common.model.base.NovelChapter;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/novel/chapter")
public class NovelChapterController {

    @Autowired
    private NovelChapterService novelChapterService;

    @PostMapping("/saveChapters")
    public ResponseMsg saveChapters(@RequestBody NovelChapter novelChapter) {
        int row = novelChapterService.saveChapters(novelChapter);

        return ResponseMsg.success("row: " + row);
    }

}
