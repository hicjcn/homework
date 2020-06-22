package com.demo.entity.enumcode;

public enum UserType {

    /**
     * 销售
     */
    Sale(0),
    /**
     * 库存管理员
     */
    Stock(1),
    /**
     * 管理员
     */
    Admin(2);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

}
