package com.demo.stu.service;

import com.demo.stu.entity.enumcode.UserType;

public interface IUserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @param type
     * @return
     */
    boolean login(String username, String password, UserType type);
}
