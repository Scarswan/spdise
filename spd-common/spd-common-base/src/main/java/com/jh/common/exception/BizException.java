package com.jh.common.exception;

import com.jh.common.enums.RetCode;
import lombok.*;

/**
 * @Description: 自定义异常信息
 * @author: jiangqk
 * @email: runner8013@gmail.com
 * @date: 2018/9/14 18:17
 * @Modified By:
 */
@Data
@NoArgsConstructor
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

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BizException(String code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BizException(RetCode retCode, Throwable e) {
        super(e);
        this.msg = retCode.getDesc();
        this.code = retCode.getCode();
    }

    public BizException(RetCode retCode, String msg) {
        this.msg = msg;
        this.code = retCode.getCode();
    }

    public BizException(RetCode retCode, String msg, Throwable e) {
        super(e);
        this.msg = msg;
        this.code = retCode.getCode();
    }

    public BizException(String msg, String code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
