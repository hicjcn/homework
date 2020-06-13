package com.demo.stu.service;

import com.demo.stu.entity.ManagerDO;

/**
 * @Description
 * @Author czc
 * @Date 2020/6/13 10:50
 */
public interface IManagerService {

    /**
     * 根据账号获取管理员
     *
     * @param userName
     * @return
     */
    ManagerDO getManagerByUserName(String userName);

}
