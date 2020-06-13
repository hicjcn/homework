package com.demo.stu.service;

import com.demo.stu.entity.ManagerDO;

public interface IManagerService {

    /**
     * 根据账号获取管理员
     *
     * @param userName
     * @return
     */
    ManagerDO getManagerByUserName(String userName);

    /**
     * 保存或更新
     * @param managerDO
     */
    boolean update(ManagerDO managerDO);

}
