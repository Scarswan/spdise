package com.jh.common.exception;


import com.jh.common.enums.RetCode;

public class ParamException extends RuntimeException {

    private String msg = RetCode.PARAM_ERROR.getDesc();

    private String code = RetCode.PARAM_ERROR.getCode();

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

    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
        this.msg = message;
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    public ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.msg = message;
    }
}
