package com.demo.restapi.controller;


import com.demo.core.db.entity.UserDO;
import com.demo.core.db.service.IUserDao;
import com.demo.core.entity.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@RestController
@RequestMapping("/db/user-do")
public class UserController {

    @Resource
    private IUserDao iUserDao;

    /**
     * 登录
     */
    @PostMapping("/login")
    public ResultBean login(@RequestBody UserDO userDO) {
        iUserDao.login(userDO);
        return ResultBean.success(null);
    }

    /**
     * 注册
     */
    @PostMapping("/registry")
    public ResultBean registry(@RequestBody UserDO userDO) {
        iUserDao.userRegistry(userDO);
        return ResultBean.success(null);
    }

}
