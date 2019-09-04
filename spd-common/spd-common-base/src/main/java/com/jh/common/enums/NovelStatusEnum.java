package com.jh.common.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum NovelStatusEnum {

    UPPER_SHELF(1, "该小说已上架"),
    // 作者主动下架或解约
    LOWER_SHELF(2, "该小说已下架"),
    VIOLATION_LOWER_SHELF(3, "该小说涉嫌违规，已下架"),
    TO_UPDATE(4, "火热更新中"),
    END(5, "该小说已完结"),

    UPLOAD(99,"该小说已上传，正在等待审核"),
    ;

    private Integer code;

    private String desc;

    NovelStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String findByCode(String roleNo) {
        for (NovelStatusEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }
}
