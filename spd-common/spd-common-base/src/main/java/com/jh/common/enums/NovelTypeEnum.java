package com.jh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum NovelTypeEnum {

    FANTASY("1", "玄幻"),
    THROUGH("2", "穿越"),
    ROMANTIC("3", "言情"),
    URBAN("4", "都市"),
    ;

    private String code;

    private String desc;

    public static String findByCode(String roleNo) {
        for (NovelTypeEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }
}
