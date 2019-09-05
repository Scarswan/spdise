package com.jh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum NovelStatusEnum {

    UPLOAD(1, "该小说已上传，正在等待审核"),
    AUDIT_UPPER_SHELF(2, "审核通过，已上架"),
    // 作者主动下架
    LOWER_SHELF(21, "该小说已下架"),
    // 违规，由工作人员通过后台下架
    VIOLATION_LOWER_SHELF(22, "该小说涉嫌违规，已下架"),
    ;

    private Integer code;

    private String desc;

    public static String findByCode(String roleNo) {
        for (NovelStatusEnum roleEnum : values()) {
            if (Objects.equals(roleEnum.code, roleNo)) {
                return roleEnum.getDesc();
            }
        }
        return null;
    }
}
