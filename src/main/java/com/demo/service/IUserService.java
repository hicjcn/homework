package com.demo.service;

import com.demo.entity.enumcode.UserType;

public interface IUserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @param type
     * @return
     */
    boolean login(String username, String password, UserType type);

    /**
     * 修改密码
     * @param stuNo
     * @param oldPwd
     * @param newPwd
     * @param type
     * @return
     */
    boolean resetPwd(String stuNo, String oldPwd, String newPwd, UserType type);
}
