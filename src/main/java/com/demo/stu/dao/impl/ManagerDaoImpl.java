package com.demo.stu.dao.impl;

import com.demo.stu.entity.ManagerDO;
import com.demo.stu.mapper.ManagerDOMapper;
import com.demo.stu.dao.IManagerDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
@Service
public class ManagerDaoImpl extends ServiceImpl<ManagerDOMapper, ManagerDO> implements IManagerDao {

}
