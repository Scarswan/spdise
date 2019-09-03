package com.jh.business.base.controller;

import com.jh.business.base.service.NovelService;
import com.jh.common.model.base.Novel;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/novel")
public class NovelController {

    @Autowired
    private NovelService novelService;

    /**
     * 上传一本小说
     *
     * @param novel Novel 对象
     * @return 受影响的行数
     */
    @PostMapping("/upperShelf")
    public ResponseMsg upperShelfNovel(@RequestBody Novel novel) {
        int row = novelService.upperShelfNovel(novel);

        return ResponseMsg.success("row: " + row);
    }

}
