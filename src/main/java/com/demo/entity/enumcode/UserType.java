package com.demo.entity.enumcode;

public enum UserType {

    /**
     * 销售员
     */
    Sale(0),
    /**
     * 采购员
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
