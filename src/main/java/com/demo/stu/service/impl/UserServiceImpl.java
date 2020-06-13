package com.demo.stu.service.impl;

import com.demo.stu.entity.enumcode.UserType;
import com.demo.stu.service.IUserService;
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
        return true;
    }
}
