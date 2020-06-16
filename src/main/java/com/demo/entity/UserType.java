package com.demo.entity;

public enum  UserType {
    /**
     * 管理员
     */
    Admin(0),
    /**
     * 库存管理员
     */
    Inventory(1),
    /**
     * 销售员
     */
    Sale(2);

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
