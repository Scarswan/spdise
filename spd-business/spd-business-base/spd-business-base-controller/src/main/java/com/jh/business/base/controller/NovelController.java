package com.jh.business.base.controller;

import com.github.pagehelper.PageInfo;
import com.jh.business.base.service.NovelService;
import com.jh.common.dto.base.NovelDTO;
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

        return ResponseMsg.successRow(row);
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

        return ResponseMsg.successRow(row);
    }

    /**
     * 批量审核
     *
     * @param novelPO
     * @return
     */
    @PostMapping("/toExamineBatch")
    public ResponseMsg toExamineBatch(@RequestBody NovelPO novelPO) {
        int rows = novelService.toExamineBatch(novelPO);

        return ResponseMsg.successRow(rows);
    }

    /**
     * 查询小说分页
     *
     * @param novelQuery
     * @return
     */

    @PostMapping("/queryPage")
    public ResponseMsg<PageInfo<NovelVO>> queryNovelPage(@RequestBody NovelQuery novelQuery) {
        PageInfo<NovelVO> novelList = novelService.queryNovelPage(novelQuery);

        return ResponseMsg.success(novelList);
    }

}
