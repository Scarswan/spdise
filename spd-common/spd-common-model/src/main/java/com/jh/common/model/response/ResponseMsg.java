package com.jh.common.model.response;

import com.jh.common.enums.RetCode;
import lombok.Data;
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

    public ResponseMsg() {
        this.code = RetCode.SUCCESS.getCode();
        this.desc = RetCode.SUCCESS.getDesc();
    }

    public ResponseMsg(RetCode retCode) {
        this.code = retCode.getCode();
        this.desc = retCode.getDesc();
    }

    public ResponseMsg(T data) {
        this.code = RetCode.SUCCESS.getCode();
        this.desc = RetCode.SUCCESS.getDesc();
        this.data = data;
    }

    public ResponseMsg(RetCode retCode, T data) {
        this.code = retCode.getCode();
        this.desc = retCode.getDesc();
        this.data = data;
    }

    public ResponseMsg(RetCode retCode, String desc, T data) {
        this.code = retCode.getCode();
        this.desc = desc;
        this.data = data;
    }

    public ResponseMsg(String code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public ResponseMsg(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 成功返回
     *
     * @return
     */
    public static ResponseMsg success() {
        return success(null);
    }

    /**
     * 成功返回
     *
     * @param obj 返回结果
     * @return
     */
    public static ResponseMsg success(Object obj) {
        return new ResponseMsg(obj);
    }

    /**
     * 错误返回
     *
     * @return
     */
    public static ResponseMsg error() {
        return new ResponseMsg(RetCode.FAIL, null);
    }

    public static ResponseMsg error(RetCode retCode) {
        return new ResponseMsg(retCode, null);
    }

    public static ResponseMsg errorByParam(String desc) {
        return new ResponseMsg(RetCode.PARAM_ERROR.getCode(), desc);
    }

    public static ResponseMsg error(RetCode retCode, String msg) {
        return new ResponseMsg(retCode.getCode(), msg);
    }

    public static ResponseMsg error(RetCode retCode, String msg, Object data) {
        return new ResponseMsg(retCode, null);
    }

    /**
     * 错误返回
     *
     * @param retCode 返回代码
     * @param data    返回数据
     * @return
     */
    public static ResponseMsg error(RetCode retCode, Object data) {
        return new ResponseMsg(retCode, data);
    }

    /**
     * 错误返回
     *
     * @param code
     * @param desc
     * @return
     */
    public static ResponseMsg error(String code, String desc) {
        return new ResponseMsg(code, desc, null);
    }

    /**
     * 错误返回
     *
     * @param code
     * @param desc
     * @param data
     * @return
     */
    public static ResponseMsg error(String code, String desc, Object data) {
        return new ResponseMsg(code, desc, data);
    }

}
