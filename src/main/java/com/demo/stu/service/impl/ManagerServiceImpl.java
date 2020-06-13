package com.demo.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.stu.dao.IManagerDao;
import com.demo.stu.entity.ManagerDO;
import com.demo.stu.service.IManagerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author czc
 * @Date 2020/6/13 10:50
 */
@Service
public class ManagerServiceImpl implements IManagerService {

    @Resource
    private IManagerDao managerDao;

    @Value("${stu.config.default.password}")
    private String defaultPassword;

    @Override
    public ManagerDO getManagerByUserName(String userName) {
        return managerDao.getOne(new QueryWrapper<ManagerDO>().eq("username", userName));
    }

    @Override
    public boolean save(ManagerDO managerDO) {
        ManagerDO managerDOByDb = managerDao.getById(managerDO.getId());
        if (null != managerDOByDb) {
            managerDO.setPassword(managerDOByDb.getPassword());
        }

        if (StringUtils.isEmpty(managerDO.getPassword())) {
            managerDO.setPassword(defaultPassword);
        }

        return managerDao.saveOrUpdate(managerDO);
    }
}
