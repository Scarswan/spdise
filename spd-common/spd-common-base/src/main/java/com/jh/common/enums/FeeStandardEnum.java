package com.jh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum FeeStandardEnum {

    NUMBER("1", "按照章节数量收费"),
    PERCENTAGE("2", "按照章节百分比收费"),
    ;

    private String code;

    private String desc;

    public static String findByCode(String roleNo) {
        for (FeeStandardEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }
}
