package com.jh.common.query.base;

import lombok.Data;

import java.util.List;

@Data
public class NovelQuery {

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 数量
     */
    private Integer pageSize = 30;

    /**
     * 小说 id 集合
     */
    private List<String> novelIds;

    /**
     * 小说类型
     */
    private Integer novelType;

    /**
     * 小说状态
     */
    private Integer novelStatus;

    /**
     * 是否完结
     */
    private Integer isEnd;

}
