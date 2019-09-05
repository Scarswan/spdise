package com.jh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum RetCode {

    // 系统返回码
    SUCCESS("000000", "处理成功"),

    PARAM_ERROR("100001", "请求参数错误"),

    FAIL("999998", "失败"),
    ;

    private String code;

    private String desc;

    public static String findByCode(String roleNo) {
        for (RetCode roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }

}
