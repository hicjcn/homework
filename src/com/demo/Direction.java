package com.demo;

/**
 * 方向枚举
 */
public enum  Direction {

    /**
     * 左
     */
    left("左"),

    /**
     * 右
     */
    right("右"),

    /**
     * 向前
     */
    forward("向前");

    private final String desc;

    Direction(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
