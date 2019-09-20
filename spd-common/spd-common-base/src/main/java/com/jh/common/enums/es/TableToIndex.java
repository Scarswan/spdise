package com.jh.common.enums.es;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TableToIndex {
    T_TEACHER("t_teacher", "teacher"),
    ;

    String indexName;

    String typeName;
}
