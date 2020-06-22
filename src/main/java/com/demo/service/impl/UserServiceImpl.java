package com.demo.service.impl;

import com.demo.entity.enumcode.UserType;
import com.demo.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    @Override
    public boolean login(String username, String password, UserType type) {
        return false;
    }

    /**
     * 修改密码
     *
     * @param stuNo
     * @param oldPwd
     * @param newPwd
     * @param type
     * @return
     */
    @Override
    public boolean resetPwd(String stuNo, String oldPwd, String newPwd, UserType type) {
        return false;
    }
}
