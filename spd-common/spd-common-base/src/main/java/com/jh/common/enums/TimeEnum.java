package com.jh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum TimeEnum {

    SECOND(1, "秒"),
    MINUTE(2, "分钟"),
    HOUR(3, "小时"),
    DAY(4, "天"),
    WEEK(5, "周"),
    MONTH(6, "月"),
    QUARTER(7, "季度"),
    YEAR(8, "年"),
    ;

    private Integer code;
    private String desc;

    public static String findByCode(Integer roleNo) {
        for (TimeEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }


}
