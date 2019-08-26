package com.jh.common.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum RetCode {

    // 系统返回码
    SUCC("000000", "处理成功"),
    FAIL("999998", "失败"),
    PARAM_ERROR("100001", "请求参数错误"),
    ;

    private String code;

    private String desc;

    RetCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String findByCode(String roleNo) {
        for (RetCode roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }

}
