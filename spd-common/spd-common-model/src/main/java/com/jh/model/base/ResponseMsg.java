package com.jh.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 请求返回数据
 *
 * @author YangFu
 * @date 2019/08/23 18:07
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMsg<T> implements Serializable {

    /**
     * 返回代码
     */
    private String code;

    /**
     * 代码描述
     */
    private String desc;

    /**
     * 返回数据
     */
    private T data;

}
