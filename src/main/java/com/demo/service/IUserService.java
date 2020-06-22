package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.StaffDO;
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

    /**
     * 分页获取员工列表
     * @param pageNo
     * @return
     */
    IPage<StaffDO> page(Integer pageNo);
}
