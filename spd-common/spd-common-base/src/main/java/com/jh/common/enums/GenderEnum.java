package com.jh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum GenderEnum {

    BOY("1", "男孩"),
    GIRL("2", "女孩"),
    MAN("3", "男"),
    WOMAN("4", "女");

    private String code;

    private String desc;

    public static String findByCode(String roleNo) {
        for (GenderEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }

}
