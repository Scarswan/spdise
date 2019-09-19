package com.jh.common.enums.rocketmq;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description rocketmq 延迟消息，延时枚举类 延时等级，与对应的延迟时间
 **/
@Getter
@AllArgsConstructor
public enum MqDelayTimeLevelEnum {

    LEVEL_1S(1, "1s"),
    LEVEL_5S(2, "5s"),
    LEVEL_10S(3, "10s"),
    LEVEL_30s(4, "30s"),
    LEVEL_1m(5, "1m"),
    LEVEL_2m(6, "2m"),
    LEVEL_3m(7, "3m"),
    LEVEL_4m(8, "4m"),
    LEVEL_5m(9, "5m"),
    LEVEL_6m(10, "6m"),
    LEVEL_7m(11, "7m"),
    LEVEL_8m(12, "8m"),
    LEVEL_9m(13, "9m"),
    LEVEL_10m(14, "10m"),
    LEVEL_20m(15, "20m"),
    LEVEL_30m(16, "30m"),
    LEVEL_1h(17, "1h"),
    LEVEL_2h(18, "2h"),
    ;

    /**
     * 状态
     */
    private Integer level;

    /**
     * 描述
     */
    private String desc;

    public static String getDesc(Integer level) {
        for (MqDelayTimeLevelEnum nameEnum : values()) {
            if (nameEnum.level == level) {
                return nameEnum.getDesc();
            }
        }
        return null;
    }
}
