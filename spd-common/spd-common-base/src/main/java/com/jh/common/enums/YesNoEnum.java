package com.jh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum YesNoEnum {

    YES_CODE(1, "是"),
    NO_CODE(2, "否");

    private Integer code;
    private String desc;

    public static String findByCode(String roleNo) {
        for (YesNoEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }
}
