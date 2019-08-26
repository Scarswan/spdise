package com.jh.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 自定义异常信息
 * @author: jiangqk
 * @email: runner8013@gmail.com
 * @date: 2018/9/14 18:17
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 返回描述
     */
    private String msg;

    /**
     * 返回代码
     */
    private String code = "999998";

}
