package com.jh.common.model;

import lombok.Data;

import java.util.Date;

/**
 * @author YangFu
 * @data 2019/08/23 17:37
 */
@Data
public class Base {

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 最后修改时间
     */
    protected Date updateTime;

}
