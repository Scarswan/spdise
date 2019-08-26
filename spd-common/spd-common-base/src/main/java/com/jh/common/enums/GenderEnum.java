package com.jh.common.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * @author YangFu
 * @data 2019/08/23 17:54
 */
@Getter
public enum GenderEnum {

    BOY("1", "男孩"),
    GIRL("2", "女孩"),
    MAN("3", "男"),
    WOMAN("4", "女");

    private String code;

    private String desc;

    GenderEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String findByCode(String roleNo) {
        for (GenderEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }

}
