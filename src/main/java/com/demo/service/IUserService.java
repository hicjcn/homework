package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.StaffDO;
import com.demo.entity.vo.StaffVO;

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

    /**
     * 创建或者保存
     * @param staffDO
     * @return
     */
    boolean save(StaffVO staffDO);

    /**
     * 删除
     * @param no
     */
    void delete(String no);
}
