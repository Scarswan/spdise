package com.jh.business.base.controller;

import com.github.pagehelper.PageInfo;
import com.jh.business.base.service.NovelService;
import com.jh.common.dto.base.NovelDTO;
import com.jh.common.model.base.Novel;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.po.base.NovelPO;
import com.jh.common.query.base.NovelQuery;
import com.jh.common.vo.base.NovelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/novel")
public class NovelController {

    @Autowired
    private NovelService novelService;

    /**
     * 上传一本小说
     *
     * @param novelDTO
     * @return
     */
    @PostMapping("/upperShelf")
    public ResponseMsg upperShelfNovel(@RequestBody NovelDTO novelDTO) {
        int row = novelService.upperShelfNovel(novelDTO);

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
     * @param novelPO
     * @return
     */
    @PostMapping("/toexamine")
    public ResponseMsg toExamine(@RequestBody NovelPO novelPO) {
        int row = novelService.toExamine(novelPO);

        return ResponseMsg.success("row: " + row);
    }

    /**
     * 查询小说分页
     *
     * @param novelQuery
     * @return
     */
    @PostMapping("/querypage")
    public ResponseMsg<PageInfo<NovelVO>> queryNovel(@RequestBody NovelQuery novelQuery) {
        PageInfo<NovelVO> novelList = novelService.queryNovel(novelQuery);

        return ResponseMsg.success(novelList);
    }

}
