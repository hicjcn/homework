package com.demo.core.db.service;

import com.demo.core.db.entity.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
public interface IUserDao extends IService<UserDO> {

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    void userRegistry(UserDO user);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    void login(UserDO user);

    /**
     * 根据编码获取用户
     *
     * @param code
     * @param type
     * @return
     */
    UserDO getUser(String code, int type);

}
