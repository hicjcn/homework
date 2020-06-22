package com.demo.service.impl;

import com.demo.entity.StaffDO;
import com.demo.mapper.StaffDOMapper;
import com.demo.service.IStaffDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工登记表 服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-22
 */
@Service
public class StaffDaoImpl extends ServiceImpl<StaffDOMapper, StaffDO> implements IStaffDao {

}
