package com.jh.common.enums;

import lombok.Getter;

@Getter
public enum YesNoEnum {

    YES_CODE(1, "是"),
    NO_CODE(2, "否");

    private Integer code;
    private String desc;

    YesNoEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
