package com.jh.model;

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
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

}
