package com.demo.stu.entity.enumcode;

public enum  UserType {

    /**
     * 学生
     */
    STUDENT(0),
    /**
     * 教师
     */
    TEACHER(1),
    /**
     * 管理员
     */
    MANAGER(2);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

}
