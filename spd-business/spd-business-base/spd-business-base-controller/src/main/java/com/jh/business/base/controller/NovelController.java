package com.jh.business.base.controller;

import com.jh.business.base.service.NovelService;
import com.jh.common.model.base.Novel;
import com.jh.common.model.response.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 下架一本小说
     *
     * @param novelId
     * @return
     */
    @PostMapping("/lowerShelf")
    public ResponseMsg lowerShelfNovel(@RequestParam("novelId") String novelId) {
        int row = novelService.lowerShelfNovel(novelId);

        return ResponseMsg.success("row: " + row);
    }

    /**
     * 批量审核
     *
     * @return
     */
    @PostMapping("/toexamine")
    public ResponseMsg toExamine(@RequestParam("novelId") List<String> novelIds){
        int row = novelService.toExamine(novelIds);

        return ResponseMsg.success("row: " + row);
    }

}
