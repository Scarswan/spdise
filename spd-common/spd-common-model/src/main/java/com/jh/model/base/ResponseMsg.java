package com.jh.model.base;

import com.jh.common.enums.RetCode;
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

    public ResponseMsg() {
        this.code = RetCode.SUCC.getCode();
        this.desc = RetCode.SUCC.getDesc();
    }

    public ResponseMsg(RetCode retCode) {
        this.code = retCode.getCode();
        this.desc = retCode.getDesc();
    }

    public ResponseMsg(T data) {
        this.code = RetCode.SUCC.getCode();
        this.desc = RetCode.SUCC.getDesc();
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

}
