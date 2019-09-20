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


    // 服务调用失败返回码
    CODE_999901("999901", "Base服务调用失败"),
    CODE_999902("999902", "Demo服务调用失败"),
    CODE_999903("999903", "QingYuan服务调用失败"),

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
