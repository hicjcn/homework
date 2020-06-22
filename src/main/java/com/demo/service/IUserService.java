package com.demo.service;

import com.demo.entity.enumcode.UserType;

public interface IUserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);

    /**
     * 修改密码
     * @param stuNo
     * @param oldPwd
     * @param newPwd
     * @return
     */
    boolean resetPwd(String stuNo, String oldPwd, String newPwd);
}
